package com.takehome.ea;

import com.takehome.ea.model.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    private int topCardIndex;

    public Deck() { //constructor
        deck = new ArrayList<Card>();
        this.topCardIndex = 51;
        // GENERATE PERMUTATIONS
        for (Card.Suit s : Card.Suit.values()) { // loop through suits
            for (Card.Rank r : Card.Rank.values()) { // loop through ranks
                deck.add(new Card(s, r)); //add a new card to the deck
            }//end rank loop
        } // end suit loop
        Collections.shuffle(deck);
    }// end Draw_Pile CONSTRUCTOR

    public int getTopCardIndex() {
        return topCardIndex;
    }

    public void setTopCardIndex(int topCardIndex) {
        this.topCardIndex = topCardIndex;
    }

    public Card drawCard(){ //function to return a card and remove it from the deck
        Card drawnCard = this.deck.get(getTopCardIndex());
        this.deck.remove(this.topCardIndex);
        this.setTopCardIndex(this.getTopCardIndex() - 1);

        return drawnCard;
    }//end drawCard() function

    public void shuffle() {
        Collections.shuffle(deck);
    }
}//end Draw_Pile class
