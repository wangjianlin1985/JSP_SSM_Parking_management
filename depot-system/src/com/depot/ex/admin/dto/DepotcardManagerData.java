// 
// 
// 

package com.depot.ex.admin.dto;

import java.util.Date;
import java.io.Serializable;

public class DepotcardManagerData implements Serializable
{
    private String cardnum;
    private String type;
    private double money;
    private String username;
    private String name;
    private String time;
    private int islose;
    private int illegalcount;
    private int payid;
    private Date deductedtime;
    private int alertpayid;
    private int alertpay_money;
    private int alertpay_type;
    
    public int getAlertpay_money() {
        return this.alertpay_money;
    }
    
    public int getAlertpay_type() {
        return this.alertpay_type;
    }
    
    public int getAlertpayid() {
        return this.alertpayid;
    }
    
    public void setAlertpay_money(final int alertpay_money) {
        this.alertpay_money = alertpay_money;
    }
    
    public void setAlertpay_type(final int alertpay_type) {
        this.alertpay_type = alertpay_type;
    }
    
    public void setAlertpayid(final int alertpayid) {
        this.alertpayid = alertpayid;
    }
    
    public Date getDeductedtime() {
        return this.deductedtime;
    }
    
    public void setDeductedtime(final Date deductedtime) {
        this.deductedtime = deductedtime;
    }
    
    public int getPayid() {
        return this.payid;
    }
    
    public void setPayid(final int payid) {
        this.payid = payid;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getCardnum() {
        return this.cardnum;
    }
    
    public void setCardnum(final String cardnum) {
        this.cardnum = cardnum;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public double getMoney() {
        return this.money;
    }
    
    public void setMoney(final double money) {
        this.money = money;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public void setTime(final String time) {
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
