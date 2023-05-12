// 
// 
// 

package com.depot.ex.admin.entity;

import java.io.Serializable;

public class CardType implements Serializable
{
    private int id;
    private String type;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
}
