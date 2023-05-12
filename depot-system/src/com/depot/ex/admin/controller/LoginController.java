// 
// 
// 

package com.depot.ex.admin.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.depot.ex.utils.Msg;
import javax.servlet.http.HttpSession;
import com.depot.ex.admin.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping({ "/login/login" })
    public String login() {
        return "login";
    }
    
    @RequestMapping({ "/login" })
    public String login1() {
        return "login";
    }
    
    @ResponseBody
    @RequestMapping({ "/login/index" })
    public Msg loginIndex(final User user, final HttpSession httpSession) {
        final User user2 = this.userService.findUserByUsername(user.getUsername());
        if (user2.getPassword().equals(user.getPassword())) {
            httpSession.setAttribute("user", (Object)user2);
            return Msg.success();
        }
        return Msg.fail().add("va_msg", "\u5bc6\u7801\u9519\u8bef");
    }
    
    @ResponseBody
    @RequestMapping({ "/login/checkUsernameExit" })
    public Msg checkUsernameExit(@RequestParam("username") final String username) {
        System.out.println("username12121212:" + username);
        final User user = this.userService.findUserByUsername(username);
        if (user == null) {
            return Msg.fail().add("va_msg", "\u7528\u6237\u540d\u4e0d\u5b58\u5728");
        }
        return Msg.success();
    }
}
