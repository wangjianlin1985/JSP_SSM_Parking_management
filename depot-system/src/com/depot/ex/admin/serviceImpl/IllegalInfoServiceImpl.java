// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import java.util.Date;
import java.util.List;
import com.depot.ex.admin.entity.IllegalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.IllegalInfoDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.IllegalInfoService;

@Service
public class IllegalInfoServiceImpl implements IllegalInfoService
{
    @Autowired
    private IllegalInfoDao illegalInfoDao;
    
    public void save(final IllegalInfo info) {
        this.illegalInfoDao.save(info);
    }
    
    public List<IllegalInfo> findAllIllegalInfo(final int page, final int size, final String name) {
        return this.illegalInfoDao.findAllIllegalInfo(page, size, name);
    }
    
    public IllegalInfo findById(final int id) {
        return this.illegalInfoDao.findById(id);
    }
    
    public void deleteById(final int id) {
        this.illegalInfoDao.deleteById(id);
    }
    
    public IllegalInfo findByCarnum(final String carnum, final Date parkin) {
        return this.illegalInfoDao.findByCarnum(carnum, parkin);
    }
    
    public IllegalInfo findByCardnum(final String cardNum) {
        return this.illegalInfoDao.findByCardnum(cardNum);
    }
    
    public int findAllIllegalInfoCount(final String name) {
        return this.illegalInfoDao.findAllIllegalInfoCount(name);
    }
    
    public List<IllegalInfo> findByUid(final int uid) {
        return this.illegalInfoDao.findByUid(uid);
    }
    
    public void updateCardnum(final String cardnum, final String cardnumNew) {
        this.illegalInfoDao.updateCardnum(cardnum, cardnumNew);
    }
    
    public IllegalInfo findByCardnumParkin(final String cardNum, final Date parkin) {
        return this.illegalInfoDao.findByCardnumParkin(cardNum, parkin);
    }
}
