package com.takehome.ea.model;

import com.takehome.ea.constants.Constant;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    protected ArrayList<Card> hand; //array list of of cards to hold  players hand
    protected int handScore; //an int that will represent the 'power' of the hand. used with evaluateHand() in hands.java

    public Player(Card FirstCard, Card SecondCard,
                  Card ThirdCard, Card FourthCard, Card FifthCard){
        hand = new ArrayList <Card>();

        hand.add(FirstCard);
        hand.add(SecondCard);
        hand.add(ThirdCard);
        hand.add(FourthCard);
        hand.add(FifthCard);

        //sort cards highest to lowest Rank
        for(int x=0; x<=4; x++){
            for(int y=0; y<=4; y++){
                if(hand.get(x).getRankEnum().ordinal() > hand.get(y).getRankEnum().ordinal())
                    Collections.swap(hand, x, y);
            }//end y loop
        }//end x loop

        this.handScore = -1;
    }//end constructor

    public void showCards(){
        for(int i = 0; i < Constant.MAX_CARDS; i++) //loop through hand
        {
            System.out.print(hand.get(i).getRankName(hand.get(i).getRankChar()) + " of " + hand.get(i).getSuitName(hand.get(i).getSuitChar()));

            if (i < Constant.MAX_CARDS -1)
                System.out.print(", ");
        }
        System.out.println("");
    } //end showCards()


    public ArrayList <Card> getHandArrayList(){
        return this.hand;
    }

    public int getHandScore() {
        return handScore;
    }

    public void setHandScore(int handScore) {
        this.handScore = handScore;
    }


}//end Player class
