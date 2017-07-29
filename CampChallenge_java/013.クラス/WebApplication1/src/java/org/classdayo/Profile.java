/*
以下の機能を持つクラスを作成してください。
1. パブリックな２つの変数と、２つの変数に値を設定するパブリックなメソッドと、
   ２つの変数の中身をprintするパブリックなメソッド
 */
package org.classdayo;

/**
 *
 * @author sasakichiaki
 */
public class Profile {
    
    //パブリックな２つの変数
    public int size = 0;
    public int bodyWeight = 0;
    
    //２つの変数に値を設定するパブリックなメソッド
   public void shintaiSokutei(int a,int b){
       this.size = a;
       this.bodyWeight = b;
       a=150;
       b=160;
   }
    
    //２つの変数の中身をprintするパブリック
   public void print(){
       System.out.print(this.size);
       System.out.print(this.bodyWeight);
   }
    
}
