// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import com.depot.ex.admin.entity.Parkinfoall;
import com.depot.ex.admin.dto.ParkinfoallData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.ParkinfoallDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.ParkinfoallService;

@Service
public class ParkinfoallServiceImpl implements ParkinfoallService
{
    @Autowired
    private ParkinfoallDao parkinfoallDao;
    
    public List<ParkinfoallData> findAllParkinfoall(final int page, final int size) {
        return this.parkinfoallDao.findAllParkinfoall(page, size);
    }
    
    public void save(final Parkinfoall parkinfoall) {
        this.parkinfoallDao.save(parkinfoall);
    }
    
    public ParkinfoallData findById(final int id) {
        return this.parkinfoallDao.findById(id);
    }
    
    public int findAllParkinfoallCount(final String name) {
        return this.parkinfoallDao.findAllParkinfoallCount(name);
    }
    
    public List<ParkinfoallData> findAllParkinfoallByLike(final int page, final int size, final String name) {
        return this.parkinfoallDao.findAllParkinfoallByLike(page, size, name);
    }
    
    public List<ParkinfoallData> findByCardNum(final String cardnum, final String name) {
        return this.parkinfoallDao.findByCardNum(cardnum, name);
    }
    
    public void updateCardnum(final String cardnum, final String cardnumNew) {
        this.parkinfoallDao.updateCardnum(cardnum, cardnumNew);
    }
    
    public List<ParkinfoallData> findByCardNumByPage(final int page, final int size, final String cardnum, final String name) {
        return this.parkinfoallDao.findByCardNumByPage(page, size, cardnum, name);
    }
}
