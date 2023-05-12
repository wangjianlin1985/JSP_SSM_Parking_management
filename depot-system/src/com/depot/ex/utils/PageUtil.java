// 
// 
// 

package com.depot.ex.utils;

import java.util.List;

public class PageUtil<T>
{
    private int page;
    private int current;
    private int count;
    private int size;
    private List<T> pages;
    private int tag;
    private int countPage;
    private String extra;
    
    public PageUtil() {
        this.size = 10;
        this.tag = 0;
    }
    
    public String getExtra() {
        return this.extra;
    }
    
    public void setExtra(final String extra) {
        this.extra = extra;
    }
    
    public int getCountPage() {
        return this.countPage;
    }
    
    public void setCountPage(final int countPage) {
        this.countPage = countPage;
    }
    
    public int getTag() {
        return this.tag;
    }
    
    public void setTag(final int tag) {
        this.tag = tag;
    }
    
    public int getPage() {
        return this.page;
    }
    
    public void setPage(final int page) {
        this.page = page;
    }
    
    public int getCurrent() {
        return this.current;
    }
    
    public void setCurrent(final int current) {
        this.current = current;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public void setCount(final int count) {
        this.count = count;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void setSize(final int size) {
        this.size = size;
    }
    
    public List<T> getPages() {
        return this.pages;
    }
    
    public void setPages(final List<T> pages) {
        this.pages = pages;
    }
}
