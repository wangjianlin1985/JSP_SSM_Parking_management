// 
// 
// 

package com.depot.ex.admin.controller;

import com.depot.ex.admin.entity.Depotcard;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.Date;
import java.util.UUID;
import com.depot.ex.admin.entity.User;
import java.util.HashSet;
import com.depot.ex.admin.dto.CouponData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.depot.ex.admin.entity.Coupon;
import com.depot.ex.utils.Msg;
import org.springframework.web.bind.annotation.RequestParam;
import com.depot.ex.admin.service.DepotcardService;
import com.depot.ex.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.CouponService;
import org.springframework.stereotype.Controller;

@Controller
public class CouponController
{
    @Autowired
    private CouponService couponService;
    @Autowired
    private UserService userService;
    @Autowired
    private DepotcardService depotcardService;
    
    @ResponseBody
    @RequestMapping({ "/index/coupon/findCouponById" })
    public Msg findCouponById(@RequestParam("id") final Integer id) {
        final Coupon coupon = this.couponService.findCouponById(id);
        if (coupon == null) {
            return Msg.fail().add("va_msg", "\u67e5\u8be2\u51fa\u9519\uff0c\u8bf7\u5237\u65b0\u9875\u9762\uff01");
        }
        return Msg.success().add("coupon", coupon);
    }
    
    @ResponseBody
    @RequestMapping({ "/index/coupon/deleteCoupon" })
    public Msg deleteCoupon(@RequestParam("id") final Integer id) {
        final Coupon coupon = this.couponService.findCouponById(id);
        if (coupon == null) {
            return Msg.fail().add("va_msg", "\u5220\u9664\u51fa\u9519\uff0c\u8bf7\u5237\u65b0\u9875\u9762\uff01");
        }
        this.couponService.deleteCoupon(id);
        return Msg.success().add("va_msg", "\u5220\u9664\u6210\u529f\uff01");
    }
    
    @ResponseBody
    @RequestMapping({ "/index/coupon/setCoupon" })
    public Msg setCoupon(final CouponData couponData) {
        final int money = couponData.getMoney();
        final int count = couponData.getCount();
        if (this.userService.findAllUserCount(3) < count) {
            return Msg.fail().add("va_msg", "\u8d85\u8fc7\u7528\u6237\u6570\u91cf\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
        }
        final List<User> list = this.userService.finAllUserByRole(3);
        final Set<User> userSet = new HashSet<User>();
        for (final User user : list) {
            userSet.add(user);
        }
        final Iterator<User> it = userSet.iterator();
        int c = 0;
        try {
            while (it.hasNext()) {
                if (c >= count) {
                    break;
                }
                final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                final User user2 = it.next();
                final Depotcard depotcard = this.depotcardService.findByCardid(user2.getCardid());
                final Coupon coupon = new Coupon();
                coupon.setCouponNum(uuid);
                coupon.setCardnum(depotcard.getCardnum());
                coupon.setMoney(money);
                coupon.setTime(new Date());
                this.couponService.addCoupon(coupon);
                ++c;
            }
        }
        catch (Exception e) {
            return Msg.fail().add("va_msg", "\u7cfb\u7edf\u51fa\u9519\uff01");
        }
        return Msg.success();
    }
}
