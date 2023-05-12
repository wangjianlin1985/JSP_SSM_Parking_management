// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.entity.Parkinfoall;
import com.depot.ex.admin.dto.ParkinfoallData;
import java.util.List;

public interface ParkinfoallService
{
    List<ParkinfoallData> findAllParkinfoall(int p0, int p1);
    
    void save(Parkinfoall p0);
    
    ParkinfoallData findById(int p0);
    
    int findAllParkinfoallCount(String p0);
    
    List<ParkinfoallData> findAllParkinfoallByLike(int p0, int p1, String p2);
    
    List<ParkinfoallData> findByCardNum(String p0, String p1);
    
    void updateCardnum(String p0, String p1);
    
    List<ParkinfoallData> findByCardNumByPage(int p0, int p1, String p2, String p3);
}
