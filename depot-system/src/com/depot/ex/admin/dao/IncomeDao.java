// 
// 
// 

package com.depot.ex.admin.dao;

import com.depot.ex.admin.dto.IncomeData;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.Income;

public interface IncomeDao extends BaseDao<Income>
{
    List<IncomeData> findAllIncome(@Param("page") int p0, @Param("size") int p1, @Param("content") String p2, @Param("startTime") String p3, @Param("endTime") String p4, @Param("num") int p5);
    
    Income findById(Integer p0);
    
    int findAllIncomeCount(@Param("content") String p0, @Param("startTime") String p1, @Param("endTime") String p2, @Param("num") int p3);
    
    void updateCardnum(@Param("cardnum") String p0, @Param("cardnumNew") String p1);
    
    List<IncomeData> findAllIncome1(@Param("content") String p0, @Param("startTime") String p1, @Param("endTime") String p2, @Param("num") int p3);
}
