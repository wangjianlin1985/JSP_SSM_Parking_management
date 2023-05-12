// 
// 
// 

package com.depot.ex.admin.dto;

import java.io.Serializable;

public class ParkinfoallData implements Serializable
{
    private int id;
    private String cardnum;
    private String parknum;
    private String carnum;
    private String parkin;
    private String parkout;
    private int parktemp;
    
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
    
    public String getParknum() {
        return this.parknum;
    }
    
    public void setParknum(final String parknum) {
        this.parknum = parknum;
    }
    
    public String getCarnum() {
        return this.carnum;
    }
    
    public void setCarnum(final String carnum) {
        this.carnum = carnum;
    }
    
    public String getParkin() {
        return this.parkin;
    }
    
    public void setParkin(final String parkin) {
        this.parkin = parkin;
    }
    
    public String getParkout() {
        return this.parkout;
    }
    
    public void setParkout(final String parkout) {
        this.parkout = parkout;
    }
    
    public int getParktemp() {
        return this.parktemp;
    }
    
    public void setParktemp(final int parktemp) {
        this.parktemp = parktemp;
    }
}
