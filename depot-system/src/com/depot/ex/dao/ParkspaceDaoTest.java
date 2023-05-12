// 
// 
// 

package com.depot.ex.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.ParkspaceService;

public class ParkspaceDaoTest extends BaseTest
{
    @Autowired
    ParkspaceService parkspaceService;
    
    @Test
    public void addParkspaceTest() {
        this.parkspaceService.addParkspace(62);
    }
}
