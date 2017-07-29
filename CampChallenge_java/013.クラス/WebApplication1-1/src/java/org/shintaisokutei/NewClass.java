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
        DataShintai no1 = new DataShintai();
        no1.setDataShintai(150, 55);
        no1.printDataShintai("no1");
    }
}
