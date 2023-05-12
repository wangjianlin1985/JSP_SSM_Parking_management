// 
// 
// 

package com.depot.ex.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.depot.ex.admin.entity.User;

public interface UserDao extends BaseDao<User>
{
    void save(User p0);
    
    User findUserById(int p0);
    
    User findUserByUserName(String p0);
    
    void saveByaddDepotCard(@Param("username") String p0, @Param("name") String p1, @Param("cardid") int p2);
    
    User findUserByCardid(@Param("cardid") int p0);
    
    List<User> findAllUser(@Param("page") int p0, @Param("size") int p1);
    
    void deleteUserByCardid(@Param("cardid") int p0);
    
    List<User> findUsersByRole(@Param("role") int p0, @Param("page") int p1, @Param("size") int p2);
    
    List<User> findUsersByRoleMan(@Param("role") int p0, @Param("page") int p1, @Param("size") int p2);
    
    void update(User p0);
    
    void delUserById(int p0);
    
    int findAllUserCount(@Param("role") int p0);
    
    int findAllUserCountMan(@Param("role") int p0);
    
    List<User> finAllUserByRole(int p0);
}
