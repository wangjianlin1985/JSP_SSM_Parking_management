// 
// 
// 

package com.depot.ex.admin.controller;

import org.springframework.transaction.annotation.Transactional;
import com.depot.ex.admin.entity.ParkInfo;
import com.depot.ex.admin.entity.Depotcard;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.depot.ex.admin.entity.User;
import com.depot.ex.utils.Msg;
import org.springframework.web.bind.annotation.RequestParam;
import com.depot.ex.admin.service.ParkinfoService;
import com.depot.ex.admin.service.DepotcardService;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private DepotcardService depotcardService;
    @Autowired
    private ParkinfoService parkinfoService;
    
    @ResponseBody
    @RequestMapping({ "/index/user/checkUsername" })
    public Msg checkUsername(@RequestParam("username") final String username) {
        System.out.println("username:" + username);
        final User user = this.userService.findUserByUsername(username);
        if (user == null) {
            return Msg.fail().add("va_msg", "\u7528\u6237\u540d\u4e0d\u5b58\u5728");
        }
        return Msg.success();
    }
    
    @ResponseBody
    @RequestMapping({ "/index/user/addUser" })
    public Msg addUser(User user) {
        user.setSex("\u7537");
        user.setName(user.getUsername());
        this.userService.save(user);
        user = this.userService.findUserByUsername(user.getUsername());
        if (user == null) {
            return Msg.fail().add("va_msg", "\u6dfb\u52a0\u5931\u8d25\uff01");
        }
        return Msg.success().add("va_msg", "\u6dfb\u52a0\u6210\u529f\uff01");
    }
    
    @ResponseBody
    @RequestMapping({ "/index/user/findUserById" })
    public Msg findUserById(@RequestParam("uid") final Integer uid, final HttpSession httpSession) {
        final User user = this.userService.findUserById(uid);
        if (user == null) {
            return Msg.fail().add("va_msg", "\u67e5\u627e\u5931\u8d25\uff01");
        }
        final User currentUser = (User)httpSession.getAttribute("user");
        return Msg.success().add("user", user).add("role", currentUser.getRole());
    }
    
    @ResponseBody
    @RequestMapping({ "/index/user/editUser" })
    public Msg editUser(final User user) {
        final int uid = user.getId();
        final User temUser = this.userService.findUserById(uid);
        if (user.getRole() == 0) {
            user.setRole(temUser.getRole());
        }
        user.setPassword(temUser.getPassword());
        user.setCardid(temUser.getCardid());
        try {
            this.userService.update(user);
        }
        catch (Exception e) {
            return Msg.fail().add("va_msg", "\u4fee\u6539\u5931\u8d25\uff01");
        }
        return Msg.success().add("va_msg", "\u4fee\u6539\u6210\u529f\uff01");
    }
    
    @ResponseBody
    @RequestMapping({ "/index/user/deleteUser" })
    @Transactional
    public Msg deleteUser(@RequestParam("uid") final Integer uid) {
        final User user = this.userService.findUserById(uid);
        if (user != null) {
            final int cardid = user.getCardid();
            if (cardid != 0) {
                final Depotcard depotcard = this.depotcardService.findByCardid(cardid);
                final String cardnum = depotcard.getCardnum();
                final ParkInfo parkInfo = this.parkinfoService.findParkinfoByCardnum(cardnum);
                if (parkInfo != null) {
                    return Msg.fail().add("va_msg", "\u6709\u8f66\u8f86\u5728\u505c\u8f66\uff0c\u4e0d\u80fd\u5220\u9664\uff01");
                }
                this.depotcardService.deleteDepotCard(cardnum);
            }
            this.userService.delUserById(uid);
            return Msg.success().add("va_msg", "\u5220\u9664\u6210\u529f\uff01");
        }
        return Msg.fail().add("va_msg", "\u5220\u9664\u5931\u8d25\uff01");
    }
}
