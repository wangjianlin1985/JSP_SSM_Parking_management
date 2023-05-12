// 
// 
// 

package com.depot.ex.admin.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.IllegalInfo;

public interface IllegalInfoDao extends BaseDao<IllegalInfo>
{
    void save(IllegalInfo p0);
    
    List<IllegalInfo> findAllIllegalInfo(@Param("page") int p0, @Param("size") int p1, @Param("name") String p2);
    
    IllegalInfo findById(int p0);
    
    void deleteById(int p0);
    
    IllegalInfo findByCarnum(@Param("carnum") String p0, @Param("parkin") Date p1);
    
    IllegalInfo findByCardnum(String p0);
    
    int findAllIllegalInfoCount(@Param("name") String p0);
    
    List<IllegalInfo> findByUid(int p0);
    
    void updateCardnum(@Param("cardnum") String p0, @Param("cardnumNew") String p1);
    
    IllegalInfo findByCardnumParkin(@Param("cardnum") String p0, @Param("parkin") Date p1);
}
