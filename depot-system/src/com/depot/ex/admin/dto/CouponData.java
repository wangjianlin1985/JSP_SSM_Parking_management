// 
// 
// 

package com.depot.ex.admin.dto;

public class CouponData
{
    private int id;
    private String couponNum;
    private int money;
    private String time;
    private String cardnum;
    private int count;
    
    public int getCount() {
        return this.count;
    }
    
    public void setCount(final int count) {
        this.count = count;
    }
    
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
    
    public String getTime() {
        return this.time;
    }
    
    public void setTime(final String time) {
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
