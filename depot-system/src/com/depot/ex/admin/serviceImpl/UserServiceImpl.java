// 
// 
// 

package com.depot.ex.admin.serviceImpl;

import java.util.List;
import com.depot.ex.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.dao.UserDao;
import org.springframework.stereotype.Service;
import com.depot.ex.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;
    
    public User findUserByUsername(final String username) {
        final User user = this.userDao.findUserByUserName(username);
        return user;
    }
    
    public void saveByaddDepotCard(final String username, final String name, final int cardid) {
        this.userDao.saveByaddDepotCard(username, name, cardid);
    }
    
    public User findUserByCardid(final int cardid) {
        return this.userDao.findUserByCardid(cardid);
    }
    
    public List<User> findAllUser(final int page, final int size) {
        return this.userDao.findAllUser(page, size);
    }
    
    public void deleteUserByCardid(final int cardid) {
        this.userDao.deleteUserByCardid(cardid);
    }
    
    public void save(final User user) {
        this.userDao.save(user);
    }
    
    public List<User> findUsersByRole(final int role, final int page, final int size) {
        return this.userDao.findUsersByRole(role, page, size);
    }
    
    public List<User> findUsersByRoleMan(final int role, final int page, final int size) {
        return this.userDao.findUsersByRoleMan(role, page, size);
    }
    
    public User findUserById(final int uid) {
        return this.userDao.findUserById(uid);
    }
    
    public void update(final User user) {
        this.userDao.update(user);
    }
    
    public void delUserById(final int uid) {
        this.userDao.delUserById(uid);
    }
    
    public int findAllUserCount(final int role) {
        return this.userDao.findAllUserCount(role);
    }
    
    public int findAllUserCountMan(final int role) {
        return this.userDao.findAllUserCountMan(role);
    }
    
    public List<User> finAllUserByRole(final int role) {
        return this.userDao.finAllUserByRole(role);
    }
}
