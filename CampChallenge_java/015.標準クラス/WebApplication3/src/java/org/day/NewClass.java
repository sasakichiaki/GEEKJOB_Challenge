/*
2016年11月4日 10時0分0秒のタイムスタンプを作成し、「年-月-日 時:分:秒」で表示してください。
 */
package org.day;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author sasakichiaki
 */
public class NewClass {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2016, 10,4,10,0,0);
        
        Date d = c.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");
        
        System.out.print(sdf.format(d));
       
    }
}
