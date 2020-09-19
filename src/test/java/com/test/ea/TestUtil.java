package com.test.ea;

import com.takehome.ea.model.Card;
import com.takehome.ea.model.Player;

import java.util.Random;

public class TestUtil {
    public static Player generateRandomHand() {
        Card[] cards = new Card[5];

        cards[0] = new Card(Card.Suit.HEARTS, Card.Rank.TWO);
        cards[1] = new Card(Card.Suit.SPADES, Card.Rank.FIVE);
        cards[2] = new Card(Card.Suit.DIAMONDS, Card.Rank.TEN);
        cards[3] = new Card(Card.Suit.CLUBS, Card.Rank.NINE);
        cards[4] = new Card(Card.Suit.HEARTS, Card.Rank.SEVEN);

        return new Player(cards[0], cards[1], cards[2], cards[3], cards[4]);
    }
}
