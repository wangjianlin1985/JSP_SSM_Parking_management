// 
// 
// 

package com.depot.ex.admin.entity;

import java.io.Serializable;

public class User implements Serializable
{
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String sex;
    private String tel;
    private int role;
    private int cardid;
    private String cardnum;
    
    public String getCardnum() {
        return this.cardnum;
    }
    
    public void setCardnum(final String cardnum) {
        this.cardnum = cardnum;
    }
    
    public int getCardid() {
        return this.cardid;
    }
    
    public void setCardid(final int cardid) {
        this.cardid = cardid;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(final String sex) {
        this.sex = sex;
    }
    
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(final String tel) {
        this.tel = tel;
    }
    
    public int getRole() {
        return this.role;
    }
    
    public void setRole(final int role) {
        this.role = role;
    }
    
    public String toString() {
        return "User [id=" + this.id + ", username=" + this.username + ", name=" + this.name + ", password=" + this.password + ", sex=" + this.sex + ", tel=" + this.tel + ", role=" + this.role + "]";
    }
}
