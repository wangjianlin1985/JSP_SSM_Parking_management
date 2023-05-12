// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.entity.ParkSpace;
import java.util.List;

public interface ParkspaceService
{
    void addParkspace(int p0);
    
    List<ParkSpace> findAllParkspace(int p0, int p1);
    
    void changeStatus(int p0, int p1);
    
    void changeStatusByParkNum(int p0, int p1);
    
    List<ParkSpace> findParkspaceByTag(int p0, int p1, int p2);
    
    int findAllParkspaceCount(int p0);
}
