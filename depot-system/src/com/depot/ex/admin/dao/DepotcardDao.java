// 
// 
// 

package com.depot.ex.admin.dao;

import com.depot.ex.admin.dto.DepotcardManagerData;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.Depotcard;

public interface DepotcardDao extends BaseDao<Depotcard>
{
    List<DepotcardManagerData> findAllDepotcard(@Param("cardnum") String p0, @Param("page") int p1, @Param("size") int p2);
    
    void save(Depotcard p0);
    
    Depotcard findByCardnum(@Param("cardnum") String p0);
    
    Depotcard findByCardid(@Param("cardid") int p0);
    
    void updateDepotcardBycardnum(Depotcard p0);
    
    void deleteDepotCard(@Param("cardnum") String p0);
    
    void addMoney(@Param("cardnum") String p0, @Param("money") double p1);
    
    int findAllDepotcardCount(@Param("cardnum") String p0);
    
    List<DepotcardManagerData> findByCardId(int p0);
    
    void updateCardnum(@Param("cardnum") String p0, @Param("cardnumNew") String p1);
}
