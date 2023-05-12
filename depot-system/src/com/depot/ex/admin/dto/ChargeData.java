// 
// 
// 

package com.depot.ex.admin.dto;

public class ChargeData
{
    private Integer hourmoney;
    private Integer monthcard;
    private Integer yearcard;
    private Integer illegal;
    
    public Integer getHourmoney() {
        return this.hourmoney;
    }
    
    public void setHourmoney(final Integer hourmoney) {
        this.hourmoney = hourmoney;
    }
    
    public Integer getMonthcard() {
        return this.monthcard;
    }
    
    public void setMonthcard(final Integer monthcard) {
        this.monthcard = monthcard;
    }
    
    public Integer getYearcard() {
        return this.yearcard;
    }
    
    public void setYearcard(final Integer yearcard) {
        this.yearcard = yearcard;
    }
    
    public Integer getIllegal() {
        return this.illegal;
    }
    
    public void setIllegal(final Integer illegal) {
        this.illegal = illegal;
    }
}
