// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.entity.Coupon;
import com.depot.ex.admin.dto.CouponData;
import java.util.List;

public interface CouponService
{
    List<CouponData> findAllCoupon(int p0, int p1, String p2);
    
    int findAllDepotcardCount(String p0);
    
    Coupon findCouponById(int p0);
    
    void deleteCoupon(Integer p0);
    
    List<CouponData> findAllCouponByCardNum(String p0, String p1);
    
    void updateCardnum(String p0, String p1);
    
    void addCoupon(Coupon p0);
}
