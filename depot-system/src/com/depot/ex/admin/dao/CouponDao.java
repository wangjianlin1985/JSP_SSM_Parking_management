// 
// 
// 

package com.depot.ex.admin.dao;

import com.depot.ex.admin.dto.CouponData;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.Coupon;

public interface CouponDao extends BaseDao<Coupon>
{
    List<CouponData> findAllCoupon(@Param("page") int p0, @Param("size") int p1, @Param("name") String p2);
    
    int findAllDepotcardCount(@Param("name") String p0);
    
    Coupon findCouponById(int p0);
    
    void deleteCoupon(@Param("id") Integer p0);
    
    List<CouponData> findAllCouponByCardNum(@Param("cardnum") String p0, @Param("name") String p1);
    
    void updateCardnum(@Param("cardnum") String p0, @Param("cardnumNew") String p1);
    
    void addCoupon(Coupon p0);
}
