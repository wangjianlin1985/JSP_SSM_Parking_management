// 
// 
// 

package com.depot.ex.admin.entity;

import java.util.Date;
import java.io.Serializable;

public class Coupon implements Serializable
{
    private int id;
    private String couponNum;
    private int money;
    private Date time;
    private String cardnum;
    
    public String getCouponNum() {
        return this.couponNum;
    }
    
    public void setCouponNum(final String couponNum) {
        this.couponNum = couponNum;
    }
    
    public String getCardnum() {
        return this.cardnum;
    }
    
    public void setCardnum(final String cardnum) {
        this.cardnum = cardnum;
    }
    
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(final Date time) {
        this.time = time;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getMoney() {
        return this.money;
    }
    
    public void setMoney(final int money) {
        this.money = money;
    }
}
