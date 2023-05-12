// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.entity.ParkInfo;
import com.depot.ex.admin.dto.FormData;

public interface ParkinfoService
{
    void saveParkinfo(FormData p0);
    
    ParkInfo findParkinfoByParknum(int p0);
    
    void deleteParkinfoByParkNum(int p0);
    
    ParkInfo findParkinfoByCardnum(String p0);
    
    void updateCardnum(String p0, String p1);
}
