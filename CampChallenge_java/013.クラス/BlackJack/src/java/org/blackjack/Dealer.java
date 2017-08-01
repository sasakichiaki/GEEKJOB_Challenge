/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blackjack;

import java.util.ArrayList;
import java.util.Random;//ランダムのクラスをインポート

/**
 *
 * @author sasakichiaki
 */
public class Dealer extends Human {

    ArrayList<Integer> cards = new ArrayList<Integer>();


    public int open() {

    int goukei = 0;
        for (int i = 0; i < myCards.size(); i++) {
            goukei = goukei + myCards.get(i);
        }

        return goukei;
    }

    public void setCard(ArrayList<Integer> n) {

        for (int i = 0; i < n.size(); i++) {//nには、ランダムに選ばれたArrayListが入ってきます。
            myCards.add(n.get(i));//myCardsの中にnに入ってる入った配列を取り出す。
        }

    }

    public boolean checkSum() {

        boolean shikou = false;

        if (open() < 14) {
            shikou = true;
        }

        return shikou;
    }
    
    public Dealer(){
        for(int i=0; i<4; i++){
        
            for(int a=1; a<14; a++){
                cards.add(a);
            }
        
        }
        
    }

    public ArrayList deal() {
        Random handOver1 = new Random();//ランダムを新しく用意
        Integer index1 = handOver1.nextInt(cards.size());//cardsの配列の数を数えてその数の中からランダムに数値を選ぶ
        Integer index2 = handOver1.nextInt(cards.size());//cardsの配列の数を数えてその数の中からランダムに数値を選ぶ

        Integer a = 0;//
        a = cards.get(index1);//ランダムに選んだ配列番号の配列情報をaに代入
        Integer b = 0;//
        b = cards.get(index2);//ランダムに選んだ配列番号の配列情報をaに代入

        ArrayList<Integer> hikiCards = new ArrayList<Integer>();//returnするためのArrayListを用意
        hikiCards.add(a);//1枚目のカード情報をhikiCardsに入れる
        hikiCards.add(b);//2枚目のカード情報をhikiCardsに入れる

        return hikiCards;
    }

    public ArrayList hit() {
        Random handOver2 = new Random();//２回目の引くカードをランダムで選ぶ
        Integer index1 = handOver2.nextInt(cards.size());//cardsの配列の数を数えてその数の中からランダムに数値を選ぶ
        Integer a = 0;
        a = cards.get(index1);//ランダムで選ばれた配列番号を指定してcardsの配列情報を手に入れる

        ArrayList<Integer> tuikaCards = new ArrayList<Integer>();//２回目のカード情報を入れるArrayListを用意
        tuikaCards.add(a);//２回目のカードの情報を追加

        return tuikaCards;//２回目のカードの情報を返却
    }
}
