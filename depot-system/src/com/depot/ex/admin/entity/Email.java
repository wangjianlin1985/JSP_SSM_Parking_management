// 
// 
// 

package com.depot.ex.admin.entity;

import java.util.Date;
import java.io.Serializable;

public class Email implements Serializable
{
    private int id;
    private int sendid;
    private int toid;
    private String title;
    private String content;
    private Date time;
    private int userisread;
    private int managerisread;
    private int userdeleted;
    private int managedelete;
    
    public int getManagedelete() {
        return this.managedelete;
    }
    
    public int getUserdeleted() {
        return this.userdeleted;
    }
    
    public void setManagedelete(final int managedelete) {
        this.managedelete = managedelete;
    }
    
    public void setUserdeleted(final int userdeleted) {
        this.userdeleted = userdeleted;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getSendid() {
        return this.sendid;
    }
    
    public void setSendid(final int sendid) {
        this.sendid = sendid;
    }
    
    public int getToid() {
        return this.toid;
    }
    
    public void setToid(final int toid) {
        this.toid = toid;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(final String content) {
        this.content = content;
    }
    
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(final Date time) {
        this.time = time;
    }
    
    public int getManagerisread() {
        return this.managerisread;
    }
    
    public void setManagerisread(final int managerisread) {
        this.managerisread = managerisread;
    }
    
    public int getUserisread() {
        return this.userisread;
    }
    
    public void setUserisread(final int userisread) {
        this.userisread = userisread;
    }
}
