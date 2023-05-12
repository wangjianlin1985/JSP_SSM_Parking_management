// 
// 
// 

package com.depot.ex.admin.entity;

import java.io.Serializable;

public class ParkSpace implements Serializable
{
    private Integer id;
    private int parkid;
    private int status;
    private int tag;
    
    public int getTag() {
        return this.tag;
    }
    
    public void setTag(final int tag) {
        this.tag = tag;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public int getParkid() {
        return this.parkid;
    }
    
    public void setParkid(final int parkid) {
        this.parkid = parkid;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(final int status) {
        this.status = status;
    }
}
