// 
// 
// 

package com.depot.ex.admin.entity;

import java.util.Date;
import java.io.Serializable;

public class Depotcard implements Serializable
{
    private int id;
    private String cardnum;
    private int type;
    private double money;
    private Date time;
    private int islose;
    private int illegalcount;
    private Date deductedtime;
    
    public Date getDeductedtime() {
        return this.deductedtime;
    }
    
    public void setDeductedtime(final Date deductedtime) {
        this.deductedtime = deductedtime;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getCardnum() {
        return this.cardnum;
    }
    
    public void setCardnum(final String cardnum) {
        this.cardnum = cardnum;
    }
    
    public int getType() {
        return this.type;
    }
    
    public void setType(final int type) {
        this.type = type;
    }
    
    public double getMoney() {
        return this.money;
    }
    
    public void setMoney(final double money) {
        this.money = money;
    }
    
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(final Date time) {
        this.time = time;
    }
    
    public int getIslose() {
        return this.islose;
    }
    
    public void setIslose(final int islose) {
        this.islose = islose;
    }
    
    public int getIllegalcount() {
        return this.illegalcount;
    }
    
    public void setIllegalcount(final int illegalcount) {
        this.illegalcount = illegalcount;
    }
}
