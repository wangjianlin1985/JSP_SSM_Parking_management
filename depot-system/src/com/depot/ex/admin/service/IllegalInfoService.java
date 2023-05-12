// 
// 
// 

package com.depot.ex.admin.service;

import java.util.Date;
import java.util.List;
import com.depot.ex.admin.entity.IllegalInfo;

public interface IllegalInfoService
{
    void save(IllegalInfo p0);
    
    List<IllegalInfo> findAllIllegalInfo(int p0, int p1, String p2);
    
    IllegalInfo findById(int p0);
    
    void deleteById(int p0);
    
    IllegalInfo findByCarnum(String p0, Date p1);
    
    IllegalInfo findByCardnum(String p0);
    
    int findAllIllegalInfoCount(String p0);
    
    List<IllegalInfo> findByUid(int p0);
    
    void updateCardnum(String p0, String p1);
    
    IllegalInfo findByCardnumParkin(String p0, Date p1);
}
