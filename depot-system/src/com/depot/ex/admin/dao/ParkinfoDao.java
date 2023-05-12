// 
// 
// 

package com.depot.ex.admin.dao;

import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.ParkInfo;

public interface ParkinfoDao extends BaseDao<ParkInfo>
{
    void save(ParkInfo p0);
    
    ParkInfo findParkinfoByParknum(@Param("parknum") int p0);
    
    void deleteParkinfoByParkNum(@Param("parknum") int p0);
    
    ParkInfo findParkinfoByCardnum(@Param("cardnum") String p0);
    
    void updateCardnum(@Param("cardnum") String p0, @Param("cardnumNew") String p1);
}
