package com.takehome.ea;

import com.takehome.ea.constants.Constant;
import com.takehome.ea.model.Card;
import com.takehome.ea.model.Player;
import java.util.Collections;
import java.util.Scanner;

public class Hands {

    private Player player1, player2;
    //GET NUMBER OF AI_PLAYERS
    public Hands(Deck gameDeck){
        player1 = initPlayer(gameDeck);
        player2 = initPlayer(gameDeck);
    }// end Hands constructor

    public Hands() {
    }



    private Player initPlayer(Deck gameDeck) {
        Card[] cards = new Card[Constant.MAX_CARDS];

        for (int i = 0; i< Constant.MAX_CARDS; i++) {
            gameDeck.shuffle();
            cards[i] = gameDeck.drawCard();
        }

        Player player = new Player(cards[0], cards[1], cards[2], cards[3], cards[4]);

        return player;
    }

    //the following function will evaluate hands for the computer and human players
    //it returns an integer from 0 - 9 for the 10 different hands we have to evaluate
    //the higher the integer, the more hands it 'beats'
    //example: an if a players hand returns a 7 from this function, it beats hands 0-6
    //the following integers correspond to the following types of hands
    //royal flush - returns 9
    //straight flush - returns 8
    //four of a kind - returns 7
    //full house - returns 6
    //flush - returns 5
    //straight - returns - returns 4
    //Three of a Kind - returns 3
    //Two Pair - returns 2
    //One Pair or Two of a Kind - returns 1
    //high card - returns 0
    public int evaluateHand(Player player){
        //EVALUATE HUMAN PLAYER

        //first sort cards by rank
        //this is done again here,
        //because this could change the order
        for(int x=0; x< Constant.MAX_PLAYERS; x++){
            for(int y=0; y< Constant.MAX_PLAYERS; y++){
                if(player.getHandArrayList().get(x).getRankEnum().ordinal() > player.getHandArrayList().get(y).getRankEnum().ordinal())
                    Collections.swap(player.getHandArrayList(), x, y);
            }//end y loop
        }//end x loop

        //get ordinals ints from card enums
        int firstCardRankOrdinal = player.getHandArrayList().get(0).getRankEnum().ordinal();
        int secondCardRankOrdinal = player.getHandArrayList().get(1).getRankEnum().ordinal();
        int thirdCardRankOrdinal = player.getHandArrayList().get(2).getRankEnum().ordinal();
        int fourthCardRankOrdinal = player.getHandArrayList().get(3).getRankEnum().ordinal();
        int fifthCardRankOrdinal = player.getHandArrayList().get(4).getRankEnum().ordinal();

        int firstCardSuitOrdinal = player.getHandArrayList().get(0).getSuitEnum().ordinal();
        int secondCardSuitOrdinal = player.getHandArrayList().get(1).getSuitEnum().ordinal();
        int thirdCardSuitOrdinal = player.getHandArrayList().get(2).getSuitEnum().ordinal();
        int fourthCardSuitOrdinal = player.getHandArrayList().get(3).getSuitEnum().ordinal();
        int fifthCardSuitOrdinal = player.getHandArrayList().get(4).getSuitEnum().ordinal();


        //the following is a bunch of if else statements
        //that cover all possible winning hands and the permutations
        //for where the pairs appear in the hand..

        if ((firstCardRankOrdinal == 12/*ACE*/) &&
                (secondCardRankOrdinal == 11 /*KING*/) &&
                (thirdCardRankOrdinal == 10 /*QUEEN*/) &&
                (fourthCardRankOrdinal == 9 /*JACK*/) &&
                (fifthCardRankOrdinal == 8 /*10*/) &&
                (firstCardSuitOrdinal == secondCardSuitOrdinal) &&
                (secondCardSuitOrdinal == thirdCardSuitOrdinal) &&
                (thirdCardSuitOrdinal == fourthCardSuitOrdinal) &&
                (fourthCardSuitOrdinal == fifthCardSuitOrdinal)) {
            System.out.println("royal flush \n");

            player.setHandScore(9);
            return 9;
        }

        //CHECK FOR A straight flush - returns 8
        else if((firstCardRankOrdinal == secondCardRankOrdinal + 1) &&
                (firstCardRankOrdinal == thirdCardRankOrdinal + 2)  &&
                (firstCardRankOrdinal == fourthCardRankOrdinal + 3)  &&
                firstCardRankOrdinal == fifthCardRankOrdinal + 4 &&
                firstCardSuitOrdinal == secondCardSuitOrdinal &&
                secondCardSuitOrdinal == thirdCardSuitOrdinal &&
                thirdCardSuitOrdinal == fourthCardSuitOrdinal &&
                fourthCardSuitOrdinal == fifthCardSuitOrdinal){
                System.out.println("straight flush \n");

            player.setHandScore(8);
            return 8;
        }
        //check if the first card was an Ace to check straight as a low card
        else if(firstCardRankOrdinal == 12 && (firstCardRankOrdinal == secondCardRankOrdinal + 9) &&
                firstCardRankOrdinal == thirdCardRankOrdinal + 10  &&
                firstCardRankOrdinal == fourthCardRankOrdinal + 11  &&
                firstCardRankOrdinal == fifthCardRankOrdinal + 12 &&
                firstCardSuitOrdinal == secondCardSuitOrdinal &&
                secondCardSuitOrdinal == thirdCardSuitOrdinal &&
                thirdCardSuitOrdinal == fourthCardSuitOrdinal &&
                fourthCardSuitOrdinal == fifthCardSuitOrdinal){

            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 3, 4);

            System.out.println("stright flush with Ace as low card - returns 8");

            player.setHandScore(8);
            return 8;
        }

        //check for four of a kind - return 7
        else if((firstCardRankOrdinal == secondCardRankOrdinal) &&
                (firstCardRankOrdinal == thirdCardRankOrdinal)  &&
                (firstCardRankOrdinal == fourthCardRankOrdinal)){
                System.out.println("four of a kind on 1st 4 cards - returns 7\n");

            player.setHandScore(7);
            return 7;
        }
        else if ((secondCardRankOrdinal == thirdCardRankOrdinal) &&
                (secondCardRankOrdinal == fourthCardRankOrdinal)  &&
                (secondCardRankOrdinal == fifthCardRankOrdinal)){
                System.out.println("four of a kind on 2nd 4 cards - returns 7\n");

            //EXTRA CREDIT sort cards in groups of pairs
            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 3, 4);

            player.setHandScore(7);
            return 7;
        }
        //check for Full House 3 pairs then 2 pair
        else if((firstCardRankOrdinal == secondCardRankOrdinal) &&
                (firstCardRankOrdinal == thirdCardRankOrdinal) &&
                (fourthCardRankOrdinal == fifthCardRankOrdinal) &&
                (firstCardRankOrdinal != fifthCardRankOrdinal)){
                System.out.println("full house 3 pair, 2 pair\n");

            player.setHandScore(6);
            return 6;
        }
        //check for Full House 2 and 3...
        else if((firstCardRankOrdinal == secondCardRankOrdinal) &&
                (thirdCardRankOrdinal == fourthCardRankOrdinal) &&
                (thirdCardRankOrdinal == fifthCardRankOrdinal) &&
                (firstCardRankOrdinal != fifthCardRankOrdinal)){
                System.out.println("full house 2 pair, then 3 pair\n");

            //EXTRA CREDIT sort cards in groups of pairs
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 3, 4);
            Collections.swap(player.getHandArrayList(), 0, 3);

            player.setHandScore(6);
            return 6;
        }
        //check for flush. return 5
        else if(firstCardSuitOrdinal == secondCardSuitOrdinal
                && thirdCardSuitOrdinal == fourthCardSuitOrdinal &&
                fourthCardSuitOrdinal == fifthCardSuitOrdinal &&
                firstCardSuitOrdinal == thirdCardSuitOrdinal &&
                firstCardSuitOrdinal == fourthCardSuitOrdinal &&
                thirdCardSuitOrdinal == fifthCardSuitOrdinal){
                System.out.println("flush\n");

            player.setHandScore(5);
            return 5;
        }
        //check for straight. return 4
        else if((firstCardRankOrdinal == secondCardRankOrdinal + 1) &&
                (firstCardRankOrdinal == thirdCardRankOrdinal + 2)  &&
                (firstCardRankOrdinal == fourthCardRankOrdinal + 3)  &&
                firstCardRankOrdinal == fifthCardRankOrdinal + 4){
                System.out.println("straight \n");

            player.setHandScore(4);
            return 4;
        }
        //check for a straight with an ace
        else if(firstCardRankOrdinal == 12 && (firstCardRankOrdinal == secondCardRankOrdinal + 9) &&
                firstCardRankOrdinal == thirdCardRankOrdinal + 10  &&
                firstCardRankOrdinal == fourthCardRankOrdinal + 11  &&
                firstCardRankOrdinal == fifthCardRankOrdinal + 12){

            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 3, 4);

            System.out.println("straight with an ace");

            player.setHandScore(4);
            return 4;
        }
        //Three of a Kind on 1st 3 cards - ret		//UNCOMMENT THE FOLLOWING 6 LINES TO TEST HUMAN PLAYERS CARDS

        else if(firstCardRankOrdinal == secondCardRankOrdinal &&
                secondCardRankOrdinal == thirdCardRankOrdinal){
                System.out.println("Three of a kind on 1st 3 cards");

            player.setHandScore(3);
            return 3;
        }
        //Three of a Kind on 2nd 3 cards - returns 3
        else if(secondCardRankOrdinal == thirdCardRankOrdinal &&
                thirdCardRankOrdinal == fourthCardRankOrdinal)
        {
            System.out.println("Three of a kind on 2st 3 cards");

            //EXTRA CREDIT sort cards in groups of pairs
            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);

            player.setHandScore(3);
            return 3;
        }
        //Three of a Kind on last 3 cards - returns 3
        else if(thirdCardRankOrdinal == fourthCardRankOrdinal &&
                fourthCardRankOrdinal == fifthCardRankOrdinal)
        {
            System.out.println("Three of a kind on 3st 3 cards");

            //EXTRA CREDIT sort cards in groups of pairs
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 3, 4);
            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);

            player1.showCards();

            player.setHandScore(3);
            return 3;
        }
        //check for Two Pair on 1st 2 card pair and 2nd 2 card pair (cards are already sorted by rank)
        else if(firstCardRankOrdinal == secondCardRankOrdinal &&
                thirdCardRankOrdinal == fourthCardRankOrdinal &&
                firstCardRankOrdinal != thirdCardRankOrdinal){
            System.out.println("Two pair on 1st 2 cards and 2nd 2 cards");
            //would already be sorted correctly for Extra credit

            player.setHandScore(2);
            return 2;
        }
        //check for Two Pair on 2nd pair of cards and last pair of cards (cards are already sorted by rank)
        else if(secondCardRankOrdinal == thirdCardRankOrdinal &&
                fourthCardRankOrdinal == fifthCardRankOrdinal &&
                firstCardRankOrdinal >= secondCardRankOrdinal){
                System.out.println("Two pair on 2nd pair of cards and last pair of cards");

            //EXTRA CREDIT sort cards in groups of pairs
            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 3, 4);

            player.setHandScore(2);
            return 2;
        }
        //check for Two Pair on 1st pair of cards and last pair of cards (cards are already sorted by rank)
        else if(firstCardRankOrdinal == secondCardRankOrdinal &&
                fourthCardRankOrdinal == fifthCardRankOrdinal &&
                thirdCardRankOrdinal >= fourthCardRankOrdinal){
                System.out.println("Two pair");

            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 3, 4);

            player.setHandScore(2);
            return 2;
        }
        //One Pair or Two of a Kind on 1st 2 cards
        else if(firstCardRankOrdinal == secondCardRankOrdinal &&
                firstCardRankOrdinal != thirdCardRankOrdinal &&
                firstCardRankOrdinal != fourthCardRankOrdinal &&
                firstCardRankOrdinal != fifthCardRankOrdinal){
            System.out.println("One Pair or Two of a Kind on 1st 2 cards");

            //would already be sorted correctly for Extra credit

            player.setHandScore(1);
            return 1;
        }
        //One Pair or Two of a Kind on 2st 2 cards
        else if(secondCardRankOrdinal == thirdCardRankOrdinal &&
                firstCardRankOrdinal != secondCardRankOrdinal &&
                fourthCardRankOrdinal != secondCardRankOrdinal &&
                fifthCardRankOrdinal != secondCardRankOrdinal){
            System.out.println("One Pair or Two of a Kind on 2nd 2 cards");

            //EXTRA CREDIT sort cards in groups of pairs
            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);

            player.setHandScore(1);
            return 1;
        }
        //One Pair or Two of a Kind on 3rd 2 cards
        else if(thirdCardRankOrdinal == fourthCardRankOrdinal &&
                thirdCardRankOrdinal != firstCardRankOrdinal &&
                thirdCardRankOrdinal != secondCardRankOrdinal &&
                thirdCardRankOrdinal != fifthCardRankOrdinal){
            System.out.println("One Pair or Two of a Kind on 3rd 2 cards");

            //EXTRA CREDIT sort cards in groups of pairs
            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);

            //player.showCards();

            player.setHandScore(1);
            return 1;
        }
        //One Pair or Two of a Kind on 4th 2 card pair
        else if(fourthCardRankOrdinal == fifthCardRankOrdinal &&
                fourthCardRankOrdinal != firstCardRankOrdinal &&
                fourthCardRankOrdinal != secondCardRankOrdinal &&
                fourthCardRankOrdinal != thirdCardRankOrdinal){
            System.out.println("One Pair or Two of a Kind on last 2 cards");

            //EXTRA CREDIT sort cards in groups of pairs
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 3, 4);
            Collections.swap(player.getHandArrayList(), 1, 2);
            Collections.swap(player.getHandArrayList(), 2, 3);
            Collections.swap(player.getHandArrayList(), 0, 1);
            Collections.swap(player.getHandArrayList(), 1, 2);

            player.setHandScore(1);
            return 1;
        }
        else{
            System.out.println("high card");

            player.setHandScore(0);
            return 0;
        }//wow! that was a lot of if statements!
    }//end evaluateHand()


    public void calculateWinner(Deck gameDeck){
        Player winner = null;
        evaluateCards(gameDeck);
        winner = this.whoWillWin(player1, player2);

        //show all hands
        System.out.println("\nPlayer1 players cards:");
        this.player1.showCards();
        System.out.println("\nPlayer2 players cards:");
        this.player2.showCards();

        System.out.println("\n-----------------------------------\n");
        System.out.println("Winner is: ");
        if(winner.equals(player1))
            System.out.println("Player1");
        else{
            System.out.println("Player2");
        }
        winner.showCards();
        System.out.println("\n-----------------------------------\n");
    }//end evaluate_hands

    //this function will return the winner out of 2 players
    public Player whoWillWin(Player a, Player b) {
        if(a.getHandScore() > b.getHandScore())
            return a;
        else if(a.getHandScore() == b.getHandScore())
        {
            int x = 0;
            while(x < Constant.MAX_CARDS)
            {
                if(a.getHandArrayList().get(x).getRankEnum().ordinal() > b.getHandArrayList().get(x).getRankEnum().ordinal())
                    return a;
                else if(a.getHandArrayList().get(x).getRankEnum().ordinal() < b.getHandArrayList().get(x).getRankEnum().ordinal())
                    return b;
                else
                    x++;
            }
        }
        return b;
    }//end who will win

    private void evaluateCards(Deck gameDeck) {
        System.out.println("Player1 has: ");
        player1.setHandScore(this.evaluateHand(player1));

        System.out.println("Player2 has: ");
        player2.setHandScore(this.evaluateHand(player2)); //needed for AIswapCardsAlgo

    }//end swapPlayersCards()
}//end hands class
