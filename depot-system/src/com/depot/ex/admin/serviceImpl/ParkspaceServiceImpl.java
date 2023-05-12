// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import java.util.List;
import com.depot.ex.admin.entity.ParkSpace;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.ParkspaceDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.ParkspaceService;

@Service
public class ParkspaceServiceImpl implements ParkspaceService
{
    @Autowired
    private ParkspaceDao parkspaceDao;
    private ParkSpace parkSpace;
    
    public void addParkspace(final int count) {
        final int max = this.parkspaceDao.findMaxSpace();
        if (max == 0) {
            for (int i = 1; i <= count; ++i) {
                this.parkSpace.setParkid(i);
                this.parkspaceDao.save(this.parkSpace);
            }
        }
        else {
            for (int i = max + 1; i <= count + max; ++i) {
                this.parkSpace.setParkid(i);
                this.parkspaceDao.save(this.parkSpace);
            }
        }
    }
    
    public List<ParkSpace> findAllParkspace(final int page, final int size) {
        return this.parkspaceDao.findAllParkspace(page, size);
    }
    
    public void changeStatus(final int id, final int status) {
        this.parkspaceDao.changeStatus(id, status);
    }
    
    public List<ParkSpace> findParkspaceByTag(final int tag, final int page, final int size) {
        return this.parkspaceDao.findParkspaceByTag(tag, page, size);
    }
    
    public void changeStatusByParkNum(final int parkNum, final int status) {
        this.parkspaceDao.changeStatusByParkNum(parkNum, status);
    }
    
    public int findAllParkspaceCount(final int tag) {
        return this.parkspaceDao.findAllParkspaceCount(tag);
    }
}
