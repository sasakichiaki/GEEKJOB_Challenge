/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.file;

import java.io.*;//javaの読み込みのパッケージ

/**
 *
 * @author sasakichiaki
 */
public class NewClass {

    public static void main(String[] args) {
        File zikosyoukai = new File("zikosyoukai/sasaki.txt");

        try {
            
            //FileWriterの作成
            FileWriter profile = new FileWriter(zikosyoukai);
            //profileを書き込み
            profile.write("氏名：佐々木千明");
            profile.write("生年月日：１９９０年５月12日");
            profile.write("簡単な自己紹介");
            //profileを閉じる
            profile.close();

        } catch (Exception ex) {
        }

    }
}
