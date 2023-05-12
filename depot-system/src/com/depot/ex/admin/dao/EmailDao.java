// 
// 
// 

package com.depot.ex.admin.dao;

import com.depot.ex.admin.dto.EmailData;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.Email;

public interface EmailDao extends BaseDao<Email>
{
    void addEmial(Email p0);
    
    Email findById(int p0);
    
    void updateManReadById(int p0);
    
    List<EmailData> findByUserId(@Param("page") int p0, @Param("size") int p1, @Param("uid") int p2, @Param("role") int p3, @Param("content") String p4, @Param("tag") Integer p5);
    
    int findAllEmailCountByUser(@Param("uid") int p0, @Param("role") int p1);
    
    void updateEmail(Email p0);
}
