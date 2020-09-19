package com.test.ea;

import com.takehome.ea.Hands;
import com.takehome.ea.model.Card;
import com.takehome.ea.model.Player;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class TestFunctionality {

    @Test
    public void testRoyalFlush() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Card testCard2 = new Card(Card.Suit.CLUBS, Card.Rank.KING);
        Card testCard3 = new Card(Card.Suit.CLUBS, Card.Rank.QUEEN);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.JACK);
        Card testCard5 = new Card(Card.Suit.CLUBS, Card.Rank.TEN);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));

    }

    @Test
    public void testStraightFlush() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.SPADES, Card.Rank.FIVE);
        Card testCard2 = new Card(Card.Suit.SPADES, Card.Rank.SIX);
        Card testCard3 = new Card(Card.Suit.SPADES, Card.Rank.SEVEN);
        Card testCard4 = new Card(Card.Suit.SPADES, Card.Rank.EIGHT);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.NINE);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);


        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }

    @Test
    public void testFourOfAKind() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.SPADES, Card.Rank.FIVE);
        Card testCard2 = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        Card testCard3 = new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.FIVE);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.TEN);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }

    @Test
    public void testFullHouse() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.SPADES, Card.Rank.FIVE);
        Card testCard2 = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        Card testCard3 = new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.KING);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.KING);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }

    @Test
    public void testFlush() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.SPADES, Card.Rank.FIVE);
        Card testCard2 = new Card(Card.Suit.HEARTS, Card.Rank.FIVE);
        Card testCard3 = new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.KING);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.KING);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }

    @Test
    public void testStraight() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.SPADES, Card.Rank.SIX);
        Card testCard2 = new Card(Card.Suit.HEARTS, Card.Rank.SEVEN);
        Card testCard3 = new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.NINE);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.TEN);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }

    @Test
    public void threeOfAKind() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.SPADES, Card.Rank.QUEEN);
        Card testCard2 = new Card(Card.Suit.HEARTS, Card.Rank.QUEEN);
        Card testCard3 = new Card(Card.Suit.DIAMONDS, Card.Rank.QUEEN);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.NINE);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.TEN);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }

    @Test
    public void twoPair() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.SPADES, Card.Rank.QUEEN);
        Card testCard2 = new Card(Card.Suit.HEARTS, Card.Rank.QUEEN);
        Card testCard3 = new Card(Card.Suit.DIAMONDS, Card.Rank.KING);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.NINE);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.NINE);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }

    @Test
    public void onePair() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.SPADES, Card.Rank.QUEEN);
        Card testCard2 = new Card(Card.Suit.HEARTS, Card.Rank.QUEEN);
        Card testCard3 = new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.TWO);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }

    @Test
    public void tesHighCard() {
        Hands hands = new Hands();
        Card testCard1 = new Card(Card.Suit.HEARTS, Card.Rank.KING);
        Card testCard2 = new Card(Card.Suit.HEARTS, Card.Rank.QUEEN);
        Card testCard3 = new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN);
        Card testCard4 = new Card(Card.Suit.CLUBS, Card.Rank.FOUR);
        Card testCard5 = new Card(Card.Suit.SPADES, Card.Rank.TWO);
        Player p1 = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);

        Player p2 = TestUtil.generateRandomHand();

        hands.evaluateHand(p1);
        hands.evaluateHand(p2);
        Player winner = hands.whoWillWin(p1, p2);

        Assert.assertTrue(winner.equals(p1));
    }
}
