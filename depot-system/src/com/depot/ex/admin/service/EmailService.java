// 
// 
// 

package com.depot.ex.admin.service;

import com.depot.ex.admin.dto.EmailData;
import java.util.List;
import com.depot.ex.admin.entity.Email;

public interface EmailService
{
    void addEmail(Email p0);
    
    Email findById(int p0);
    
    void updateManReadById(int p0);
    
    List<EmailData> findByUserId(int p0, int p1, int p2, int p3, String p4, Integer p5);
    
    int findAllEmailCountByUser(int p0, int p1);
    
    void updateEmail(Email p0);
}
