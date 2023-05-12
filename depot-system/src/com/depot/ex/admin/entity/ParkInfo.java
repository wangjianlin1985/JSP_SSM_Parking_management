// 
// 
// 

package com.depot.ex.admin.entity;

import java.util.Date;
import java.io.Serializable;

public class ParkInfo implements Serializable
{
    private int id;
    private int parknum;
    private String cardnum;
    private String carnum;
    private Date parkin;
    private int parktem;
    
    public int getParktem() {
        return this.parktem;
    }
    
    public void setParktem(final int parktem) {
        this.parktem = parktem;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getParknum() {
        return this.parknum;
    }
    
    public void setParknum(final int parknum) {
        this.parknum = parknum;
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
    
    public Date getParkin() {
        return this.parkin;
    }
    
    public void setParkin(final Date parkin) {
        this.parkin = parkin;
    }
    
    public String toString() {
        return "ParkInfo [id=" + this.id + ", parknum=" + this.parknum + ", cardnum=" + this.cardnum + ", carnum=" + this.carnum + ", parkin=" + this.parkin + ", parktem=" + this.parktem + "]";
    }
}
