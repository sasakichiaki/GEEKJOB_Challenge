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
public class NewClass {

    public static void main(String[] args) {

        try {

            Date start = new Date();
            SimpleDateFormat st
                    = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

            System.out.print(st.format(start));

            File logu = new File("logu/logu.txt");
            FileWriter loguStart = new FileWriter(logu);
            loguStart.write(st.format(start));
            loguStart.write("（開始）");
            loguStart.close();
            
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
            SimpleDateFormat fi
                    = new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");

            System.out.print(fi.format(finish));
            
            FileWriter loguFinish = new FileWriter(logu, true);
            loguFinish.write(fi.format(finish));
            loguFinish.write("（終了）");
//            FileReader loguFinish = new FileReader(logu);
//            BufferedReader br = new BufferedReader(loguFinish);
            

        } catch (Exception ex) {

        }

    }

}
