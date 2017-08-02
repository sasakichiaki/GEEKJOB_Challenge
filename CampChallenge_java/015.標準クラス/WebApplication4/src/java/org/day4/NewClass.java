/*
2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。
 */
package org.day4;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author sasakichiaki
 */
public class NewClass {
    public static void main(String[] args){
        Calendar a = Calendar.getInstance();
        Calendar b = Calendar.getInstance();
        
        a.set(2015,0,1,0,0,0);
        b.set(2015,11,31,23,59,59);
        
        Date c =a.getTime();
        Date d =b.getTime();
        
        long result = d.getTime() - c.getTime();
        System.out.print(d.getTime()-c.getTime());
        System.out.print(result);
    }
    
    
    
}
