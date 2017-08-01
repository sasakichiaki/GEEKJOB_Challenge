/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blackjack;

import java.util.ArrayList;

/**
 *
 * @author sasakichiaki
 */
public class User extends Human {

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

        if (open() < 17) {
            shikou = true;
        }

        return shikou;
    }

}
