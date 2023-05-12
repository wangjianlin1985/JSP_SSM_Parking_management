// 
// 
// 

package com.depot.ex.admin.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

public class IllegalInfo implements Serializable
{
    private int id;
    private String cardnum;
    private String carnum;
    private String illegalInfo;
    private Date time;
    private String formatDate;
    private int uid;
    private String username;
    private String deleted;
    private Date parkin;
    
    public Date getParkin() {
        return this.parkin;
    }
    
    public void setParkin(final Date parkin) {
        this.parkin = parkin;
    }
    
    public String getDelete() {
        return this.deleted;
    }
    
    public void setDelete(final String delete) {
        this.deleted = delete;
    }
    
    public String getFormatDate() {
        return this.formatDate;
    }
    
    public void setFormatDate(final String formatDate) {
        this.formatDate = formatDate;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
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
    
    public String getCarnum() {
        return this.carnum;
    }
    
    public void setCarnum(final String carnum) {
        this.carnum = carnum;
    }
    
    public String getIllegalInfo() {
        return this.illegalInfo;
    }
    
    public void setIllegalInfo(final String illegalInfo) {
        this.illegalInfo = illegalInfo;
    }
    
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(final Date time) {
        this.time = time;
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String formatDate = formatter.format(time);
        this.setFormatDate(formatDate);
    }
    
    public int getUid() {
        return this.uid;
    }
    
    public void setUid(final int uid) {
        this.uid = uid;
    }
}
