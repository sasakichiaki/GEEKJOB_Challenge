/*
openというabstractな公開メソッドを用意してください。
setCardというArrayListを引数とした、abstractな公開メソッドを用意してください。
checkSumというabstractな公開メソッドを用意してください。
myCardsというArrayListの変数を用意してください。
 */
package org.blackjack;
import java.util.ArrayList;
/**
 *
 * @author sasakichiaki
 */
abstract class Human {
    abstract public int open();//カードを合計するメソッド
    abstract public void setCard(ArrayList<Integer> n);//myCardsのArrayListにカード情報を.addしていくメソッド.nは仮置き
    abstract public boolean checkSum();//追加カードを引くか判断するメソッド
    ArrayList<Integer> myCards = new ArrayList<Integer>();//共通で使うArrayList
}
