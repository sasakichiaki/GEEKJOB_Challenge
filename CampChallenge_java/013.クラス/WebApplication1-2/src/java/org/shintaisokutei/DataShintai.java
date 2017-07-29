/*
以下の機能を持つクラスを作成してください。
1. パブリックな２つの変数と、２つの変数に値を設定するパブリックなメソッドと、２つの変数の中身をprintするパブリックなメソッド
 */
package org.shintaisokutei;

/**
 *
 * @author sasakichiaki
 */
public class DataShintai {
    //パブリックな２つの変数
    public int size =0;
    public int bodyWeight =0;
    
    //２つの変数に値を設定するパブリックなメソッド
    public void setDataShintai(int a,int b){
     this.size=a;
     this.bodyWeight=b;
    }
    
    //２つの変数の中身をprintするパブリックなメソッド
    public void printDataShintai(String a){
        System.out.print(a+"の身長は"+size+"cmです。体重は"+bodyWeight+"kgです。");
    }
    
}
