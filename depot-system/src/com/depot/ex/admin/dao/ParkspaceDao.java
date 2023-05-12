// 
// 
// 

package com.depot.ex.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.ParkSpace;

public interface ParkspaceDao extends BaseDao<ParkSpace>
{
    void save(ParkSpace p0);
    
    int findMaxSpace();
    
    List<ParkSpace> findAllParkspace(@Param("page") int p0, @Param("size") int p1);
    
    void changeStatus(@Param("id") int p0, @Param("status") int p1);
    
    List<ParkSpace> findParkspaceByTag(@Param("tag") int p0, @Param("page") int p1, @Param("size") int p2);
    
    void changeStatusByParkNum(@Param("parkNum") int p0, @Param("status") int p1);
    
    int findAllParkspaceCount(@Param("tag") int p0);
}
