// 
// 
// 

package com.depot.ex.admin.dao;

import com.depot.ex.admin.dto.ChargeData;
import com.depot.ex.admin.entity.DepotInfo;

public interface DepotInfoDao extends BaseDao<DepotInfo>
{
    void update(ChargeData p0);
    
    DepotInfo findById(int p0);
}
