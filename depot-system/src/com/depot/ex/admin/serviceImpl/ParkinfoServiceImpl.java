// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import com.depot.ex.admin.entity.ParkInfo;
import java.util.Date;
import com.depot.ex.admin.dto.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.ParkinfoDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.ParkinfoService;

@Service
public class ParkinfoServiceImpl implements ParkinfoService
{
    @Autowired
    private ParkinfoDao parkinfoDao;
    
    public void saveParkinfo(final FormData data) {
        final Date parkin = new Date();
        final ParkInfo parkInfo = new ParkInfo();
        parkInfo.setParknum(data.getParkNum());
        parkInfo.setCarnum(data.getCarNum());
        parkInfo.setCardnum(data.getCardNum());
        parkInfo.setParktem(data.getParkTem());
        parkInfo.setParkin(parkin);
        this.parkinfoDao.save(parkInfo);
    }
    
    public ParkInfo findParkinfoByParknum(final int parknum) {
        return this.parkinfoDao.findParkinfoByParknum(parknum);
    }
    
    public void deleteParkinfoByParkNum(final int parkNum) {
        this.parkinfoDao.deleteParkinfoByParkNum(parkNum);
    }
    
    public ParkInfo findParkinfoByCardnum(final String cardnum) {
        return this.parkinfoDao.findParkinfoByCardnum(cardnum);
    }
    
    public void updateCardnum(final String cardnum, final String cardnumNew) {
        this.parkinfoDao.updateCardnum(cardnum, cardnumNew);
    }
}
