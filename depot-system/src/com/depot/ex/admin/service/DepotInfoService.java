// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.entity.DepotInfo;
import com.depot.ex.admin.dto.ChargeData;

public interface DepotInfoService
{
    void update(ChargeData p0);
    
    DepotInfo findById(int p0);
}
