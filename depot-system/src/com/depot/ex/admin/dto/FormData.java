// 
// 
// 

package com.depot.ex.admin.dto;

import java.util.Date;

public class FormData
{
    private int id;
    private int parkNum;
    private String cardNum;
    private String carNum;
    private int parkTem;
    private Date parkin;
    private Date parkout;
    private Integer tag;
    private String illegalInfo;
    private int payid;
    private int pay_money;
    private int pay_type;
    
    public int getPayid() {
        return this.payid;
    }
    
    public void setPayid(final int payid) {
        this.payid = payid;
    }
    
    public int getPay_money() {
        return this.pay_money;
    }
    
    public void setPay_money(final int pay_money) {
        this.pay_money = pay_money;
    }
    
    public int getPay_type() {
        return this.pay_type;
    }
    
    public void setPay_type(final int pay_type) {
        this.pay_type = pay_type;
    }
    
    public String getIllegalInfo() {
        return this.illegalInfo;
    }
    
    public void setIllegalInfo(final String illegalInfo) {
        this.illegalInfo = illegalInfo;
    }
    
    public Integer getTag() {
        return this.tag;
    }
    
    public void setTag(final Integer tag) {
        this.tag = tag;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getParkNum() {
        return this.parkNum;
    }
    
    public void setParkNum(final int parkNum) {
        this.parkNum = parkNum;
    }
    
    public Date getParkout() {
        return this.parkout;
    }
    
    public void setParkout(final Date parkout) {
        this.parkout = parkout;
    }
    
    public Date getParkin() {
        return this.parkin;
    }
    
    public void setParkin(final Date parkin) {
        this.parkin = parkin;
    }
    
    public String getCarNum() {
        return this.carNum;
    }
    
    public void setCarNum(final String carNum) {
        this.carNum = carNum;
    }
    
    public String getCardNum() {
        return this.cardNum;
    }
    
    public void setCardNum(final String cardNum) {
        this.cardNum = cardNum;
    }
    
    public int getParkTem() {
        return this.parkTem;
    }
    
    public void setParkTem(final int parkTem) {
        this.parkTem = parkTem;
    }
    
    public String toString() {
        return "FormData [id=" + this.id + ", parkNum=" + this.parkNum + ", cardNum=" + this.cardNum + ", carNum=" + this.carNum + ", parkTem=" + this.parkTem + ", parkin=" + this.parkin + ", parkout=" + this.parkout + ", tag=" + this.tag + "]";
    }
}
