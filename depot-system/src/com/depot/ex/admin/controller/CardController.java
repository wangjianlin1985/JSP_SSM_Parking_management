// 
// 
// 

package com.depot.ex.admin.controller;

import java.text.SimpleDateFormat;
import org.springframework.util.StringUtils;
import com.depot.ex.admin.dto.CouponData;
import com.depot.ex.admin.entity.ParkInfo;
import com.depot.ex.admin.entity.User;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.Transactional;
import com.depot.ex.admin.entity.Depotcard;
import com.depot.ex.utils.Constants;
import com.depot.ex.admin.entity.Income;
import java.util.Date;
import com.depot.ex.admin.dto.DepotcardManagerData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.depot.ex.admin.entity.CardType;
import java.util.List;
import com.depot.ex.utils.Msg;
import com.depot.ex.admin.service.ParkinfoallService;
import com.depot.ex.admin.service.IllegalInfoService;
import com.depot.ex.admin.service.CouponService;
import com.depot.ex.admin.service.IncomeService;
import com.depot.ex.admin.service.ParkinfoService;
import com.depot.ex.admin.service.UserService;
import com.depot.ex.admin.service.CardtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.DepotcardService;
import org.springframework.stereotype.Controller;

@Controller
public class CardController
{
    @Autowired
    private DepotcardService depotcardService;
    @Autowired
    private CardtypeService cardtypeService;
    @Autowired
    private UserService userService;
    @Autowired
    private ParkinfoService parkinfoService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private IllegalInfoService illegalInfoService;
    @Autowired
    private ParkinfoallService parkinfoallService;
    
    @ResponseBody
    @RequestMapping({ "/index/card/findAllCardType" })
    public Msg findAllCardType() {
        final List<CardType> cardTypes = this.cardtypeService.findAllCardType();
        return Msg.success().add("cardTypes", cardTypes);
    }
    
    @ResponseBody
    @RequestMapping({ "/index/card/addDepotCard" })
    @Transactional
    public Msg addDepotCard(final DepotcardManagerData depotcardManagerData) {
        if (Integer.parseInt(depotcardManagerData.getType()) != 1) {
            depotcardManagerData.setDeductedtime(new Date());
        }
        final Depotcard depotcard = this.depotcardService.save(depotcardManagerData);
        double money = 0.0;
        final Income income = new Income();
        if (depotcard == null) {
            return Msg.fail().add("va_msg", "\u8d26\u53f7\u5df2\u5b58\u5728\uff01");
        }
        final int type = Integer.parseInt(depotcardManagerData.getType());
        if (type == 2) {
            money = depotcard.getMoney();
            money -= Constants.MONTHCARD;
            depotcard.setMoney(money);
            this.depotcardService.updateDepotcardBycardnum(depotcard);
            income.setMoney(Constants.MONTHCARD);
        }
        if (type == 3) {
            money = depotcard.getMoney();
            money -= Constants.YEARCARD;
            depotcard.setMoney(money);
            this.depotcardService.updateDepotcardBycardnum(depotcard);
            income.setMoney(Constants.YEARCARD);
        }
        income.setCardnum(depotcard.getCardnum());
        income.setType(type);
        income.setMethod(depotcardManagerData.getPayid());
        income.setSource(0);
        income.setTime(new Date());
        this.incomeService.save(income);
        this.userService.saveByaddDepotCard(depotcardManagerData.getUsername(), depotcardManagerData.getName(), depotcard.getId());
        return Msg.success().add("depotcard", depotcard).add("username", depotcardManagerData.getUsername());
    }
    
    @ResponseBody
    @RequestMapping({ "/index/card/findDepotCardByCardnum" })
    public Msg findDepotCardByCardnum(@RequestParam("cardnum") final String cardnum, final HttpSession session) {
        final User currentUser = (User)session.getAttribute("user");
        final Depotcard depotcard = this.depotcardService.findByCardnum(cardnum);
        if (depotcard == null) {
            return Msg.fail();
        }
        final int typeid = depotcard.getType();
        final int cardid = depotcard.getId();
        final User user = this.userService.findUserByCardid(cardid);
        final CardType cardType = this.cardtypeService.findCardTypeByid(typeid);
        final List<CardType> cardTypes = this.cardtypeService.findAllCardType();
        return Msg.success().add("depotcard", depotcard).add("cardType", cardType).add("cardTypes", cardTypes).add("user", user).add("user_role", currentUser.getRole());
    }
    
    @ResponseBody
    @RequestMapping({ "/index/card/alertDepotCard" })
    public Msg alertDepotCard(final DepotcardManagerData depotcardManagerData) {
        final Depotcard depotcard = this.depotcardService.findByCardnum(depotcardManagerData.getCardnum());
        if (depotcardManagerData.getType() == null) {
            depotcardManagerData.setType(Integer.toString(depotcard.getType()));
        }
        if (depotcardManagerData.getIslose() != depotcard.getIslose() || Integer.parseInt(depotcardManagerData.getType()) != depotcard.getType()) {
            depotcard.setIslose(depotcardManagerData.getIslose());
            depotcard.setType(Integer.parseInt(depotcardManagerData.getType()));
            this.depotcardService.updateDepotcardBycardnum(depotcard);
            return Msg.success();
        }
        return Msg.fail();
    }
    
    @ResponseBody
    @RequestMapping({ "/index/card/deleteDepotCard" })
    @Transactional
    public Msg deleteDepotCard(@RequestParam("cardnum") final String cardnum) {
        final Depotcard depotcard = this.depotcardService.findByCardnum(cardnum);
        final int cardid = depotcard.getId();
        final ParkInfo parkInfo = this.parkinfoService.findParkinfoByCardnum(cardnum);
        if (parkInfo != null) {
            return Msg.fail().add("va_msg", "\u6709\u8f66\u8f86\u5728\u505c\u8f66\uff0c\u4e0d\u80fd\u5220\u9664\uff01");
        }
        this.userService.deleteUserByCardid(cardid);
        this.depotcardService.deleteDepotCard(cardnum);
        return Msg.success();
    }
    
    @ResponseBody
    @RequestMapping({ "/index/card/findCoupon" })
    public Msg findCoupon(@RequestParam("cardnum") final String cardnum) {
        final List<CouponData> list = this.couponService.findAllCouponByCardNum(cardnum, "");
        if (list != null && list.size() > 0) {
            return Msg.success().add("val", list.get(0).getMoney());
        }
        return Msg.fail();
    }
    
    @ResponseBody
    @RequestMapping({ "/index/card/rechargeDepotCardSubmit" })
    public Msg rechargeDepotCardSubmit(final DepotcardManagerData depotcardManagerData) {
        final Depotcard depotcard = this.depotcardService.findByCardnum(depotcardManagerData.getCardnum());
        final Income income = new Income();
        if (depotcard == null) {
            return Msg.fail().add("va_msg", "\u8be5\u505c\u8f66\u5361\u4e0d\u5b58\u5728\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
        }
        final double money = depotcard.getMoney() + depotcardManagerData.getMoney();
        final List<CouponData> list = this.couponService.findAllCouponByCardNum(depotcardManagerData.getCardnum(), "");
        if (list != null && list.size() > 0) {
            this.couponService.deleteCoupon(list.get(0).getId());
        }
        try {
            this.depotcardService.addMoney(depotcardManagerData.getCardnum(), money);
        }
        catch (Exception e) {
            return Msg.fail().add("va_msg", "\u51fa\u73b0\u9519\u8bef\uff01");
        }
        income.setCardnum(depotcardManagerData.getCardnum());
        income.setType(depotcard.getType());
        income.setSource(0);
        income.setMethod(depotcardManagerData.getPayid());
        income.setMoney(money);
        income.setTime(new Date());
        this.incomeService.save(income);
        return Msg.success();
    }
    
    @ResponseBody
    @RequestMapping({ "/index/card/changeLoseCard" })
    @Transactional
    public Msg changeLoseCard(final DepotcardManagerData depotcardManagerData) {
        final String cardnum = depotcardManagerData.getCardnum();
        final Depotcard depotcard = this.depotcardService.findByCardnum(cardnum);
        final User user = this.userService.findUserByCardid(depotcard.getId());
        if (StringUtils.isEmpty((Object)cardnum)) {
            return Msg.fail();
        }
        final Date date = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        final String trans = formatter.format(date);
        final String dateStr = trans.replaceAll(" ", "").replaceAll("-", "");
        final String cardnumNew = String.valueOf(user.getUsername()) + dateStr;
        Depotcard depotcardNew = this.depotcardService.findByCardnum(cardnumNew);
        if (depotcardNew != null) {
            return Msg.fail();
        }
        this.depotcardService.updateCardnum(cardnum, cardnumNew);
        this.couponService.updateCardnum(cardnum, cardnumNew);
        this.illegalInfoService.updateCardnum(cardnum, cardnumNew);
        this.incomeService.updateCardnum(cardnum, cardnumNew);
        this.parkinfoService.updateCardnum(cardnum, cardnumNew);
        this.parkinfoallService.updateCardnum(cardnum, cardnumNew);
        depotcardNew = this.depotcardService.findByCardnum(cardnumNew);
        depotcardNew.setIslose(0);
        this.depotcardService.updateDepotcardBycardnum(depotcardNew);
        return Msg.success();
    }
    
    @ResponseBody
    @RequestMapping({ "/index/card/isAlertType" })
    public Msg isAlertType(final DepotcardManagerData depotcardManagerData) {
        final Depotcard depotcard = this.depotcardService.findByCardnum(depotcardManagerData.getCardnum());
        if (depotcardManagerData.getType() == null) {
            depotcardManagerData.setType(Integer.toString(depotcard.getType()));
        }
        if (depotcard.getType() == Integer.parseInt(depotcardManagerData.getType()) || Integer.parseInt(depotcardManagerData.getType()) <= 1) {
            return Msg.success().add("money_pay", 0);
        }
        double money = depotcard.getMoney();
        final List<CouponData> listCou = this.couponService.findAllCouponByCardNum(depotcard.getCardnum(), "");
        if (listCou != null && listCou.size() > 0) {
            money += listCou.get(0).getMoney();
        }
        if (Integer.parseInt(depotcardManagerData.getType()) == 2) {
            if (money < Constants.MONTHCARD) {
                return Msg.fail().add("money_pay", Constants.MONTHCARD - money);
            }
            return Msg.success().add("money_pay", Constants.MONTHCARD);
        }
        else {
            if (money < Constants.YEARCARD) {
                return Msg.fail().add("money_pay", Constants.YEARCARD - money);
            }
            return Msg.success().add("money_pay", Constants.MONTHCARD);
        }
    }
}
