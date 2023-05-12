// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.dto.IncomeData;
import java.util.List;
import com.depot.ex.admin.entity.Income;

public interface IncomeService
{
    void save(Income p0);
    
    List<IncomeData> findAllIncome(int p0, int p1, String p2, String p3, String p4, int p5);
    
    Income findById(Integer p0);
    
    int findAllIncomeCount(String p0, String p1, String p2, int p3);
    
    void updateCardnum(String p0, String p1);
    
    List<IncomeData> findAllIncome(String p0, String p1, String p2, Integer p3);
}
