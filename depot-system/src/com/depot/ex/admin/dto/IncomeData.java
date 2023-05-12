// 
// 
// 

package com.depot.ex.admin.dto;

public class IncomeData
{
    private int id;
    private double money;
    private int method;
    private int type;
    private String carnum;
    private String cardnum;
    private int isillegal;
    private int source;
    private String time;
    private long duration;
    
    public IncomeData() {
        this.source = 1;
    }
    
    public long getDuration() {
        return this.duration;
    }
    
    public void setDuration(final long duration) {
        this.duration = duration;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public double getMoney() {
        return this.money;
    }
    
    public void setMoney(final double money) {
        this.money = money;
    }
    
    public int getMethod() {
        return this.method;
    }
    
    public void setMethod(final int method) {
        this.method = method;
    }
    
    public int getType() {
        return this.type;
    }
    
    public void setType(final int type) {
        this.type = type;
    }
    
    public String getCarnum() {
        return this.carnum;
    }
    
    public void setCarnum(final String carnum) {
        this.carnum = carnum;
    }
    
    public String getCardnum() {
        return this.cardnum;
    }
    
    public void setCardnum(final String cardnum) {
        this.cardnum = cardnum;
    }
    
    public int getIsillegal() {
        return this.isillegal;
    }
    
    public void setIsillegal(final int isillegal) {
        this.isillegal = isillegal;
    }
    
    public int getSource() {
        return this.source;
    }
    
    public void setSource(final int source) {
        this.source = source;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public void setTime(final String time) {
        this.time = time;
    }
}
