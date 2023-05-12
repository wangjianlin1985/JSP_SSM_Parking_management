// 
// 
// 

package com.depot.ex.admin.entity;

import java.util.Date;
import java.io.Serializable;

public class Parkinfoall implements Serializable
{
    private int id;
    private String cardnum;
    private int parknum;
    private String carnum;
    private Date parkin;
    private Date parkout;
    private int parktemp;
    private int uid;
    
    public int getUid() {
        return this.uid;
    }
    
    public void setUid(final int uid) {
        this.uid = uid;
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
    
    public int getParknum() {
        return this.parknum;
    }
    
    public void setParknum(final int i) {
        this.parknum = i;
    }
    
    public String getCarnum() {
        return this.carnum;
    }
    
    public void setCarnum(final String carnum) {
        this.carnum = carnum;
    }
    
    public Date getParkin() {
        return this.parkin;
    }
    
    public void setParkin(final Date parkin) {
        this.parkin = parkin;
    }
    
    public Date getParkout() {
        return this.parkout;
    }
    
    public void setParkout(final Date parkout) {
        this.parkout = parkout;
    }
    
    public int getParktemp() {
        return this.parktemp;
    }
    
    public void setParktemp(final int parktemp) {
        this.parktemp = parktemp;
    }
}
