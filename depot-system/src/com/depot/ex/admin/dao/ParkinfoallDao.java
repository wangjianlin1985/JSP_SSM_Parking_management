// 
// 
// 

package com.depot.ex.admin.dao;

import com.depot.ex.admin.dto.ParkinfoallData;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.Parkinfoall;

public interface ParkinfoallDao extends BaseDao<Parkinfoall>
{
    List<ParkinfoallData> findAllParkinfoall(@Param("page") int p0, @Param("size") int p1);
    
    ParkinfoallData findById(int p0);
    
    int findAllParkinfoallCount(@Param("name") String p0);
    
    List<ParkinfoallData> findAllParkinfoallByLike(@Param("page") int p0, @Param("size") int p1, @Param("name") String p2);
    
    List<ParkinfoallData> findByCardNum(@Param("cardnum") String p0, @Param("name") String p1);
    
    void updateCardnum(@Param("cardnum") String p0, @Param("cardnumNew") String p1);
    
    List<ParkinfoallData> findByCardNumByPage(@Param("page") int p0, @Param("size") int p1, @Param("cardnum") String p2, @Param("name") String p3);
}
