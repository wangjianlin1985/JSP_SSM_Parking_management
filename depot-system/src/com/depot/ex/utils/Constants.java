// 
// 
// 

package com.depot.ex.utils;

public class Constants
{
    public static String basePath;
    public static int PAGEFIRST;
    public static int PAGESIZE;
    public static int TEMPMONEY;
    public static int HOURMONEY;
    public static int MONTHCARD;
    public static int YEARCARD;
    public static int ILLEGAL;
    
    static {
        Constants.basePath = "/depot-system";
        Constants.PAGEFIRST = 0;
        Constants.PAGESIZE = 10;
        Constants.TEMPMONEY = 10;
        Constants.HOURMONEY = 8;
        Constants.MONTHCARD = 1920;
        Constants.YEARCARD = 21120;
        Constants.ILLEGAL = 50;
    }
}
