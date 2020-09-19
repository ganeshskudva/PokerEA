package com.takehome.ea;

import com.takehome.ea.constants.Constant;

public class PokerEA {

    public static void main(String[] args) {
        Deck gameDeck = new Deck();
        Hands hand = new Hands(gameDeck);
        System.out.println("The deck is being shuffled...\n");
        System.out.println("The cards are being dealt to " + Constant.MAX_PLAYERS  +" players\n");
        hand.calculateWinner(gameDeck);
    }
}
