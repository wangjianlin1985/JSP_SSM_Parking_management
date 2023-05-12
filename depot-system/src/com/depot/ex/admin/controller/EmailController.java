// 
// 
// 

package com.depot.ex.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import com.depot.ex.admin.entity.User;
import com.depot.ex.admin.entity.Email;
import com.depot.ex.utils.Msg;
import javax.servlet.http.HttpSession;
import com.depot.ex.admin.dto.EmailData;
import com.depot.ex.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.EmailService;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController
{
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping({ "index/email/addEmail" })
    public Msg addEmail(final EmailData emailData, final HttpSession session) {
        final Email email = new Email();
        final User user = (User)session.getAttribute("user");
        try {
            if (user.getRole() == 3) {
                email.setTitle(emailData.getTitle());
                email.setContent(emailData.getContent());
                email.setSendid(user.getId());
                email.setToid(0);
                email.setTime(new Date());
            }
            else {
                final Email email2 = this.emailService.findById(emailData.getId());
                this.emailService.updateManReadById(emailData.getId());
                email.setSendid(user.getId());
                email.setToid(email2.getSendid());
                email.setTitle(emailData.getTitle());
                email.setContent(emailData.getContent());
                email.setTime(new Date());
            }
        }
        catch (Exception e) {
            return Msg.fail().add("va_msg", "\u7cfb\u7edf\u9519\u8bef\uff01");
        }
        this.emailService.addEmail(email);
        return Msg.success().add("va_msg", "\u6dfb\u52a0\u6210\u529f\uff01");
    }
    
    @ResponseBody
    @RequestMapping({ "index/email/delete" })
    public Msg delete(final EmailData emailData, final HttpSession session) {
        final User user = (User)session.getAttribute("user");
        return Msg.success();
    }
    
    @ResponseBody
    @RequestMapping({ "index/email/detail" })
    public Msg detail(final EmailData emailData, final HttpSession session) {
        int respon = 0;
        final User user = (User)session.getAttribute("user");
        final Email email = this.emailService.findById(emailData.getId());
        if (user.getRole() != 3) {
            final User user2 = this.userService.findUserById(email.getSendid());
            if (email.getManagerisread() < 2 && user2.getRole() == 3) {
                email.setManagerisread(1);
                this.emailService.updateEmail(email);
                respon = 1;
            }
        }
        else {
            email.setUserisread(1);
            this.emailService.updateEmail(email);
        }
        return Msg.success().add("email", email).add("respon", respon);
    }
    
    @ResponseBody
    @RequestMapping({ "index/email/responEmailSubmit" })
    public Msg responEmailSubmit(final EmailData emailData, final HttpSession session) {
        final User user = (User)session.getAttribute("user");
        final Email email1 = this.emailService.findById(emailData.getId());
        final Email email2 = new Email();
        email2.setTitle(emailData.getTitle());
        email2.setContent(emailData.getContent());
        email2.setTime(new Date());
        email2.setToid(email1.getSendid());
        email2.setSendid(user.getId());
        this.emailService.addEmail(email2);
        email1.setManagerisread(2);
        this.emailService.updateEmail(email1);
        return Msg.success();
    }
    
    @ResponseBody
    @RequestMapping({ "index/email/deleteEmai" })
    public Msg deleteEmai(final EmailData emailData, final HttpSession session) {
        try {
            final User user = (User)session.getAttribute("user");
            final Email email = this.emailService.findById(emailData.getId());
            if (user.getRole() != 3) {
                email.setManagedelete(1);
            }
            else {
                email.setUserdeleted(1);
            }
            this.emailService.updateEmail(email);
        }
        catch (Exception e) {
            return Msg.fail().add("va_msg", "\u5220\u9664\u5931\u8d25\uff01");
        }
        return Msg.success().add("va_msg", "\u5220\u9664\u6210\u529f\uff01");
    }
}
