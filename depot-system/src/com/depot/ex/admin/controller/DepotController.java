// 
// 
// 

package com.depot.ex.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.depot.ex.admin.dto.ParkinfoallData;
import com.depot.ex.utils.Msg;
import org.springframework.web.bind.annotation.RequestParam;
import com.depot.ex.admin.service.ParkspaceService;
import com.depot.ex.admin.service.DepotcardService;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.ParkinfoallService;
import org.springframework.stereotype.Controller;

@Controller
public class DepotController
{
    @Autowired
    private ParkinfoallService parkinfoallService;
    @Autowired
    private DepotcardService depotcardService;
    @Autowired
    private ParkspaceService parkspaceService;
    
    @ResponseBody
    @RequestMapping({ "/index/depot/findParkinfoById" })
    public Msg findParkinfo(@RequestParam("id") final Integer id) {
        final ParkinfoallData parkinfoall = this.parkinfoallService.findById(id);
        if (parkinfoall != null) {
            return Msg.success().add("parkinfoall", parkinfoall);
        }
        return Msg.fail().add("va_msg", "\u7cfb\u7edf\u51fa\u9519\uff0c\u627e\u4e0d\u5230\u8be5\u505c\u8f66\u4fe1\u606f\u3002");
    }
    
    @ResponseBody
    @RequestMapping({ "/index/depot/checkTem" })
    public Msg checkTem() {
        final int cardcount = this.depotcardService.findAllDepotcardCount("");
        final int parkcount = this.parkspaceService.findAllParkspaceCount(0);
        if (cardcount + 5 >= parkcount) {
            return Msg.fail();
        }
        return Msg.success();
    }
}
