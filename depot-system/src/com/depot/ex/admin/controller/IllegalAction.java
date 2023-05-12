// 
// 
// 

package com.depot.ex.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import com.depot.ex.admin.entity.User;
import com.depot.ex.admin.entity.IllegalInfo;
import java.text.SimpleDateFormat;
import com.depot.ex.utils.Msg;
import org.springframework.web.bind.annotation.RequestParam;
import com.depot.ex.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.IllegalInfoService;
import org.springframework.stereotype.Controller;

@Controller
public class IllegalAction
{
    @Autowired
    private IllegalInfoService illegalInfoService;
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping({ "index/illegal/findIllegalInfo" })
    public Msg findIllegalInfo(@RequestParam("id") final Integer id) {
        final IllegalInfo illegalInfo = this.illegalInfoService.findById(id);
        if (illegalInfo == null) {
            return Msg.fail().add("va_msg", "\u53d1\u751f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u67e5\u770b\uff01");
        }
        final int uid = illegalInfo.getUid();
        final User user = this.userService.findUserById(uid);
        illegalInfo.setUsername(user.getUsername());
        final Date date = illegalInfo.getTime();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String time = formatter.format(date);
        illegalInfo.setFormatDate(time);
        return Msg.success().add("illegalInfo", illegalInfo);
    }
    
    @RequestMapping({ "index/illegal/deleteIllegalInfo" })
    @ResponseBody
    public Msg deleteIllegalInfo(@RequestParam("id") final Integer id) {
        try {
            this.illegalInfoService.deleteById(id);
        }
        catch (Exception e) {
            return Msg.fail();
        }
        return Msg.success();
    }
}
