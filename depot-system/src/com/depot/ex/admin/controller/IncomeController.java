// 
// 
// 

package com.depot.ex.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.depot.ex.admin.entity.Income;
import com.depot.ex.utils.Msg;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.IncomeService;
import org.springframework.stereotype.Controller;

@Controller
public class IncomeController
{
    @Autowired
    private IncomeService incomeService;
    
    @ResponseBody
    @RequestMapping({ "/index/income/findIncomeInfo" })
    public Msg findIncomeInfo(@RequestParam("id") final Integer id) {
        final Income income = this.incomeService.findById(id);
        if (income != null) {
            return Msg.success().add("income", income);
        }
        return Msg.fail().add("va_msg", "\u7cfb\u7edf\u51fa\u9519\uff0c\u627e\u4e0d\u5230\u8be5\u6536\u5165\u4fe1\u606f\u3002");
    }
}
