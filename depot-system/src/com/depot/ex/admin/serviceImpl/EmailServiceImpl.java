// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import com.depot.ex.admin.dto.EmailData;
import java.util.List;
import com.depot.ex.admin.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.EmailDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService
{
    @Autowired
    private EmailDao emailDao;
    
    public void addEmail(final Email email) {
        this.emailDao.addEmial(email);
    }
    
    public Email findById(final int id) {
        return this.emailDao.findById(id);
    }
    
    public void updateManReadById(final int id) {
        this.emailDao.updateManReadById(id);
    }
    
    public List<EmailData> findByUserId(final int page, final int size, final int id, final int role, final String content, final Integer tag) {
        return this.emailDao.findByUserId(page, size, id, role, content, tag);
    }
    
    public int findAllEmailCountByUser(final int uid, final int role) {
        return this.emailDao.findAllEmailCountByUser(uid, role);
    }
    
    public void updateEmail(final Email email) {
        this.emailDao.updateEmail(email);
    }
}
