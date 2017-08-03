/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hyouzyun;

import java.awt.FlowLayout;//
import javax.swing.*;//GUIアプリケーションを開発する為
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 *
 * @author sasakichiaki
 */
public class NewClass1 {

    public static void main(String[] args) {
        // ファイルオープン
        File logu = new File("logu/test.txt");
        //どこにあるfileを対象にすることができる
        //File+へんすうめい＋new+File(ここが生成パス);

        try {

            // FileWriter作成
            FileWriter fw = new FileWriter(logu);
            // loguのタイトル
            fw.write("ここからログが始まります。\n");
            fw.close();

            //ここで時間を開始時間を確認
            Date start = new Date();
            SimpleDateFormat stTime
                    = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

            // FileWriter作成 -- 追記モード
            FileWriter st = new FileWriter(logu, true);
            // 書き込み
            st.write(stTime.format(start));
            st.write("開始\n");
            // クローズ
            st.close();

            JFrame frame = new JFrame("サイトタイトル");//javax.swing.*のパッケージの
            JLabel label = new JLabel("ここが表示される文字");//短いテキスト文字列や画像の表示領域
            JButton button = new JButton("ボタン");//「プッシュ」ボタンの実装

            frame.getContentPane().setLayout(new FlowLayout());//フレームの制作
            frame.getContentPane().add(label);//コンテンツに追加する
            frame.getContentPane().add(button);//コンテンツに追加する
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//押した時の処理
            frame.setSize(500, 500);//フレームのサイズ
            frame.setVisible(true);//フレームの表示・非表示を指定

            Date finish = new Date();
            SimpleDateFormat fiTime
                    = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

            FileWriter fi = new FileWriter(logu, true);
            // 書き込み
            fi.write(fiTime.format(finish));
            fi.write("終了\n");
            // クローズ
            fi.close();

        } catch (Exception ex) {

        }
    }
}
