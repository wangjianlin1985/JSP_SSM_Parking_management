// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import com.depot.ex.admin.entity.Coupon;
import com.depot.ex.admin.dto.CouponData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.CouponDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService
{
    @Autowired
    private CouponDao couponDao;
    
    public List<CouponData> findAllCoupon(final int page, final int size, final String name) {
        return this.couponDao.findAllCoupon(page, size, name);
    }
    
    public int findAllDepotcardCount(final String name) {
        return this.couponDao.findAllDepotcardCount(name);
    }
    
    public Coupon findCouponById(final int id) {
        return this.couponDao.findCouponById(id);
    }
    
    public void deleteCoupon(final Integer id) {
        this.couponDao.deleteCoupon(id);
    }
    
    public List<CouponData> findAllCouponByCardNum(final String cardnum, final String name) {
        return this.couponDao.findAllCouponByCardNum(cardnum, name);
    }
    
    public void updateCardnum(final String cardnum, final String cardnumNew) {
        this.couponDao.updateCardnum(cardnum, cardnumNew);
    }
    
    public void addCoupon(final Coupon coupon) {
        this.couponDao.addCoupon(coupon);
    }
}
