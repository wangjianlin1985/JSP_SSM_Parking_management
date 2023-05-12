// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.entity.Depotcard;
import com.depot.ex.admin.dto.DepotcardManagerData;
import java.util.List;

public interface DepotcardService
{
    List<DepotcardManagerData> findAllDepotcard(String p0, int p1, int p2);
    
    Depotcard save(DepotcardManagerData p0);
    
    Depotcard findByCardid(int p0);
    
    Depotcard findByCardnum(String p0);
    
    void updateDepotcardBycardnum(Depotcard p0);
    
    void deleteDepotCard(String p0);
    
    void addMoney(String p0, double p1);
    
    int findAllDepotcardCount(String p0);
    
    List<DepotcardManagerData> findByCardId(int p0);
    
    void updateCardnum(String p0, String p1);
}
