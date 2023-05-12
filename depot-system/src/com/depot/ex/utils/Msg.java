// 
// 
// 

package com.depot.ex.utils;

import java.util.HashMap;
import java.util.Map;

public class Msg
{
    private int code;
    private String msg;
    private Map<String, Object> extend;
    
    public Msg() {
        this.extend = new HashMap<String, Object>();
    }
    
    public static Msg success() {
        final Msg result = new Msg();
        result.setCode(100);
        result.setMsg("\u5904\u7406\u6210\u529f");
        return result;
    }
    
    public static Msg fail() {
        final Msg result = new Msg();
        result.setCode(200);
        result.setMsg("\u5904\u7406\u5931\u8d25");
        return result;
    }
    
    public Msg add(final String key, final Object value) {
        this.getExtend().put(key, value);
        return this;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public Map<String, Object> getExtend() {
        return this.extend;
    }
    
    public void setExtend(final Map<String, Object> extend) {
        this.extend = extend;
    }
}
