/*
以下の機能を持つクラスを作成してください。
1. パブリックな２つの変数と、２つの変数に値を設定するパブリックなメソッドと、２つの変数の中身をprintするパブリックなメソッド
 */
package org.shintaisokutei;

/**
 *
 * @author sasakichiaki
 */
public class NewClass {

    //２つの変数の中身をprintするパブリックなメソッド
    public static void main(String[] args) {
//        DataShintai sasaki = new DataShintai();
//        sasaki.setDataShintai(150, 55);
//        sasaki.printDataShintai("sasaki");
        
        NewClass1 sasaki= new NewClass1();
                sasaki.setDataShintai(150, 55);
        sasaki.printDataShintai("sasaki");
        sasaki.setDelete();
        
        sasaki.printDataShintai("sasaki");
    }
}
