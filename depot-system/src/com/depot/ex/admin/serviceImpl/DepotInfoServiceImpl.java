// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import com.depot.ex.admin.entity.DepotInfo;
import com.depot.ex.admin.dto.ChargeData;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.DepotInfoDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.DepotInfoService;

@Service
public class DepotInfoServiceImpl implements DepotInfoService
{
    @Autowired
    private DepotInfoDao depotInfoDao;
    
    public void update(final ChargeData chargeData) {
        this.depotInfoDao.update(chargeData);
    }
    
    public DepotInfo findById(final int id) {
        return this.depotInfoDao.findById(id);
    }
}
