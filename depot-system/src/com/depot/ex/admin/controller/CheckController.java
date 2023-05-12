// 
// 
// 

package com.depot.ex.admin.controller;

import org.springframework.util.StringUtils;
import com.depot.ex.utils.Constants;
import javax.servlet.http.HttpSession;
import com.depot.ex.admin.entity.User;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.depot.ex.admin.entity.IllegalInfo;
import com.depot.ex.admin.entity.ParkInfo;
import com.depot.ex.admin.dto.CouponData;
import com.depot.ex.admin.entity.Income;
import com.depot.ex.admin.entity.Parkinfoall;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.depot.ex.admin.entity.Depotcard;
import com.depot.ex.utils.Msg;
import com.depot.ex.admin.dto.FormData;
import org.springframework.ui.Model;
import com.depot.ex.admin.service.CouponService;
import com.depot.ex.admin.service.IncomeService;
import com.depot.ex.admin.service.ParkinfoallService;
import com.depot.ex.admin.service.IllegalInfoService;
import com.depot.ex.admin.service.UserService;
import com.depot.ex.admin.service.DepotcardService;
import com.depot.ex.admin.service.ParkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.ParkinfoService;
import org.springframework.stereotype.Controller;

@Controller
public class CheckController
{
    @Autowired
    private ParkinfoService parkinfoservice;
    @Autowired
    private ParkspaceService parkspaceService;
    @Autowired
    private DepotcardService depotcardService;
    @Autowired
    private UserService userService;
    @Autowired
    private IllegalInfoService illegalInfoService;
    @Autowired
    private ParkinfoallService parkinfoallService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private CouponService couponService;
    
    @RequestMapping({ "/index/check/checkIn" })
    @ResponseBody
    @Transactional
    public Msg checkIn(final Model model, final FormData data) {
        final Depotcard depotcard = this.depotcardService.findByCardnum(data.getCardNum());
        if (data.getParkTem() != 1) {
            if (depotcard == null) {
                return Msg.fail().add("va_msg", "\u8be5\u5361\u4e0d\u5b58\u5728\uff01");
            }
            if (depotcard.getIslose() == 1) {
                return Msg.fail().add("va_msg", "\u8be5\u5361\u5df2\u6302\u5931\uff01");
            }
        }
        this.parkinfoservice.saveParkinfo(data);
        this.parkspaceService.changeStatus(data.getId(), 1);
        return Msg.success();
    }
    
    @RequestMapping({ "/index/check/checkOut" })
    @ResponseBody
    @Transactional
    public Msg checkOut(final Model model, final FormData data) {
        final int pay_money = data.getPay_money();
        final Date parkout = new Date();
        final Parkinfoall parkinfoall = new Parkinfoall();
        final ParkInfo parkInfo = this.parkinfoservice.findParkinfoByParknum(data.getParkNum());
        if (data.getPay_type() == 9) {
            final Depotcard depotcard = this.depotcardService.findByCardnum(data.getCardNum());
            final IllegalInfo illegalInfo = this.illegalInfoService.findByCardnumParkin(data.getCardNum(), parkInfo.getParkin());
            final Income income = new Income();
            final List<CouponData> coupons = this.couponService.findAllCouponByCardNum(data.getCardNum(), "");
            if (coupons != null && coupons.size() > 0) {
                this.couponService.deleteCoupon(coupons.get(0).getId());
            }
            this.depotcardService.addMoney(data.getCardNum(), 0.0);
            income.setMoney(pay_money);
            income.setMethod(data.getPayid());
            income.setCardnum(data.getCardNum());
            income.setCarnum(data.getCarNum());
            if (depotcard != null) {
                income.setType(depotcard.getType());
            }
            if (illegalInfo != null) {
                income.setIsillegal(1);
            }
            income.setSource(1);
            income.setTime(parkout);
            final Date parkin = parkInfo.getParkin();
            final long day = parkout.getTime() - parkin.getTime();
            long time = day / 60000L;
            if (day % 60000L > 0L) {
                ++time;
            }
            income.setDuration(time);
            this.incomeService.save(income);
        }
        else {
            if (data.getPay_type() == 9) {
                return Msg.fail().add("va_msg", "\u7cfb\u7edf\u51fa\u9519\uff01");
            }
            if (data.getPay_type() == 0) {
                final Depotcard depotcard = this.depotcardService.findByCardnum(data.getCardNum());
                final IllegalInfo illegalInfo = this.illegalInfoService.findByCardnumParkin(data.getCardNum(), parkInfo.getParkin());
                double money = depotcard.getMoney();
                final List<CouponData> coupons2 = this.couponService.findAllCouponByCardNum(data.getCardNum(), "");
                if (coupons2 != null && coupons2.size() > 0) {
                    money -= coupons2.get(0).getMoney();
                    this.couponService.deleteCoupon(coupons2.get(0).getId());
                }
                money -= pay_money;
                this.depotcardService.addMoney(depotcard.getCardnum(), money);
            }
        }
        parkinfoall.setCardnum(parkInfo.getCardnum());
        parkinfoall.setCarnum(parkInfo.getCarnum());
        parkinfoall.setParkin(parkInfo.getParkin());
        parkinfoall.setParknum(data.getParkNum());
        parkinfoall.setParkout(parkout);
        parkinfoall.setParktemp(parkInfo.getParktem());
        this.parkinfoallService.save(parkinfoall);
        this.parkspaceService.changeStatusByParkNum(data.getParkNum(), 0);
        this.parkinfoservice.deleteParkinfoByParkNum(data.getParkNum());
        return Msg.success();
    }
    
    @RequestMapping({ "/index/check/findParkinfoByParknum" })
    @ResponseBody
    public Msg findParkinfoByParknum(@RequestParam("parkNum") final int parknum) {
        final ParkInfo parkInfo = this.parkinfoservice.findParkinfoByParknum(parknum);
        return Msg.success().add("parkInfo", parkInfo);
    }
    
    @RequestMapping({ "/index/check/findParkinfoByCardnum" })
    @ResponseBody
    public Msg findParkinfoByCardnum(@RequestParam("cardnum") final String cardnum) {
        final ParkInfo parkInfo = this.parkinfoservice.findParkinfoByCardnum(cardnum);
        if (parkInfo != null) {
            return Msg.success().add("parkInfo", parkInfo);
        }
        return Msg.fail();
    }
    
    @RequestMapping({ "/index/check/findParkinfoDetailByParknum" })
    @ResponseBody
    public Msg findParkinfoDetailByParknum(@RequestParam("parkNum") final int parknum) {
        final ParkInfo parkInfo = this.parkinfoservice.findParkinfoByParknum(parknum);
        if (parkInfo == null) {
            return Msg.fail();
        }
        final Date date = parkInfo.getParkin();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String parkin = formatter.format(date);
        System.out.println(parkInfo.toString());
        final String cardnum = parkInfo.getCardnum();
        final Depotcard depotcard = this.depotcardService.findByCardnum(cardnum);
        int cardid = 0;
        User user = null;
        if (depotcard != null) {
            cardid = depotcard.getId();
            user = this.userService.findUserByCardid(cardid);
        }
        return Msg.success().add("parkInfo", parkInfo).add("user", user).add("parkin", parkin);
    }
    
    @RequestMapping({ "/index/check/illegalSubmit" })
    @ResponseBody
    public Msg illegalSubmit(final FormData data, final HttpSession httpSession) {
        final User currentUser = (User)httpSession.getAttribute("user");
        final ParkInfo parkInfo = this.parkinfoservice.findParkinfoByCardnum(data.getCardNum());
        final IllegalInfo info = new IllegalInfo();
        final IllegalInfo illegalInfo = this.illegalInfoService.findByCardnumParkin(data.getCardNum(), parkInfo.getParkin());
        if (illegalInfo != null) {
            return Msg.fail().add("va_msg", "\u6dfb\u52a0\u5931\u8d25,\u5df2\u7ecf\u6709\u8fdd\u89c4\uff01");
        }
        info.setCardnum(data.getCardNum());
        info.setCarnum(data.getCarNum());
        info.setIllegalInfo(data.getIllegalInfo());
        info.setUid(currentUser.getId());
        final Date date = new Date();
        info.setTime(date);
        info.setParkin(parkInfo.getParkin());
        info.setDelete("N");
        try {
            this.illegalInfoService.save(info);
        }
        catch (Exception e) {
            e.printStackTrace();
            return Msg.fail().add("va_msg", "\u6dfb\u52a0\u5931\u8d25");
        }
        return Msg.success().add("va_msg", "\u6dfb\u52a0\u6210\u529f");
    }
    
    @RequestMapping({ "/index/check/ispay" })
    @ResponseBody
    public Msg ispay(@RequestParam("parknum") final Integer parknum) {
        final ParkInfo parkInfo = this.parkinfoservice.findParkinfoByParknum(parknum);
        final Date date = new Date();
        long time = 0L;
        long day = 0L;
        int illegalmoney = 0;
        if (parkInfo == null) {
            return Msg.fail().add("type", 9);
        }
        final IllegalInfo illegalInfo = this.illegalInfoService.findByCarnum(parkInfo.getCarnum(), parkInfo.getParkin());
        if (illegalInfo != null) {
            illegalmoney = Constants.ILLEGAL;
        }
        if (StringUtils.isEmpty((Object)parkInfo.getCardnum())) {
            final Date parkin = parkInfo.getParkin();
            day = date.getTime() - parkin.getTime();
            time = day / 3600000L;
            if (day % 3600000L > 0L) {
                ++time;
            }
            return Msg.success().add("money_pay", time * Constants.TEMPMONEY + illegalmoney).add("va_msg", "\u4e34\u65f6\u505c\u8f66" + ((illegalmoney > 0) ? (",\u6709\u8fdd\u89c4\uff1a" + illegalInfo.getIllegalInfo()) : ""));
        }
        final String cardnum = parkInfo.getCardnum();
        final Depotcard depotcard = this.depotcardService.findByCardnum(cardnum);
        if (depotcard != null && depotcard.getType() == 1) {
            final double balance = depotcard.getMoney();
            int money = 0;
            final List<CouponData> coupons = this.couponService.findAllCouponByCardNum(cardnum, "");
            if (coupons != null && coupons.size() > 0) {
                money = coupons.get(0).getMoney();
            }
            final Date parkin = parkInfo.getParkin();
            day = date.getTime() - parkin.getTime();
            time = day / 3600000L;
            if (day % 3600000L > 0L) {
                ++time;
            }
            if (balance + money - illegalmoney < time * Constants.HOURMONEY) {
                return Msg.success().add("money_pay", time * Constants.HOURMONEY + illegalmoney - money - balance).add("va_msg", "\u4f59\u989d\u4e0d\u8db3" + ((illegalmoney > 0) ? (",\u6709\u8fdd\u89c4\uff1a" + illegalInfo.getIllegalInfo()) : ""));
            }
            return Msg.fail().add("type", 0).add("money_pay", time * Constants.HOURMONEY + illegalmoney - money);
        }
        else {
            final Date deductedtime = depotcard.getDeductedtime();
            if (depotcard.getType() > 1) {
                day = date.getTime() - deductedtime.getTime();
            }
            if (depotcard.getType() == 3) {
                time = day / -1702967296L;
            }
            if (depotcard.getType() == 4) {
                time = day / 1471228928L;
            }
            if (time < 1L) {
                return Msg.fail().add("type", 1);
            }
            final double balance2 = depotcard.getMoney();
            int money2 = 0;
            final List<CouponData> coupons2 = this.couponService.findAllCouponByCardNum(cardnum, "");
            if (coupons2 != null && coupons2.size() > 0) {
                money2 = coupons2.get(0).getMoney();
            }
            final Date parkin = parkInfo.getParkin();
            day = date.getTime() - parkin.getTime();
            time = day / 3600000L;
            if (day % 3600000L > 0L) {
                ++time;
            }
            if (balance2 + money2 - illegalmoney < time * Constants.HOURMONEY) {
                return Msg.success().add("money_pay", time * Constants.HOURMONEY + illegalmoney - money2 - balance2).add("va_msg", "\u4f59\u989d\u4e0d\u8db3" + ((illegalmoney > 0) ? (",\u6709\u8fdd\u89c4\uff1a" + illegalInfo.getIllegalInfo()) : ""));
            }
            return Msg.fail().add("type", 0);
        }
    }
}
