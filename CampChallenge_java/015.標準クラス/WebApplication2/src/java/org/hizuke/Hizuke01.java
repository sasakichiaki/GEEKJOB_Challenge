/*
現在の日時を「年-月-日 時:分:秒」で表示してください。
 */
package org.hizuke;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author sasakichiaki
 */
public class Hizuke01 {
        public static void main(String[] args) {
        // カレンダーインスタンスの作成
        // 今日の日付作成
        Date now = new Date();
        // SimpleDateFormat作成
        SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

        System.out.print(sdf.format(now));
    }
}
