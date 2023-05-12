// 
// 
// 

package com.depot.ex.admin.service;

import java.util.List;
import com.depot.ex.admin.entity.User;

public interface UserService
{
    User findUserByUsername(String p0);
    
    void saveByaddDepotCard(String p0, String p1, int p2);
    
    User findUserByCardid(int p0);
    
    List<User> findAllUser(int p0, int p1);
    
    void deleteUserByCardid(int p0);
    
    void save(User p0);
    
    List<User> findUsersByRole(int p0, int p1, int p2);
    
    List<User> findUsersByRoleMan(int p0, int p1, int p2);
    
    User findUserById(int p0);
    
    void update(User p0);
    
    void delUserById(int p0);
    
    int findAllUserCount(int p0);
    
    int findAllUserCountMan(int p0);
    
    List<User> finAllUserByRole(int p0);
}
