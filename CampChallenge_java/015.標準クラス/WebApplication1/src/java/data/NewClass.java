/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author sasakichiaki
 */
public class NewClass {
        public static void main(String[] args) {
        // カレンダーインスタンスの作成
//        Calendar c = Calendar.getInstance();

        // 2017年8月12日 18時10分33秒
//        c.set(2016, 0, 1, 0, 0, 0);
//        
//        int y = c.get(Calendar.YEAR);
//        int m = c.get(Calendar.MONTH)+1;
//        int d = c.get(Calendar.DAY_OF_MONTH);
//        int h = c.get(Calendar.HOUR_OF_DAY);
//        int mi = c.get(Calendar.MINUTE);
//        int s = c.get(Calendar.SECOND);
//        System.out.print(c);
//        System.out.print(y+"年"+m+"月"+d+"日"+h+"時"+mi+":分"+s+":秒");

        // 当日の日時で日付情報を作成
       
        Calendar c = Calendar.getInstance();
        c.set(2016, 0, 1, 0, 0, 0);
        
        Date d = c.getTime();
        
        System.out.print(d.getTime());


    }
}
