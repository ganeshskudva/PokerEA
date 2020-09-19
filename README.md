# PokerEA
## How to Run Application
### Run in Terminal
I have provided **PokerEA.jar**</br>
`$java -jar PokerEA.jar`
### Run via Intellij IDE
1. Open the proj in Intellij IDE via pom.xml
2. Run -> Edit Configurations -> New Application
3. Provide any suitable name
4. Main Class is PokerEA
5. Apply -> Run

## How to Run Test cases
### Run in Terminal
`mvn clean test`
### Run via Intellij IDE
1. Go to test->java folder
2. Right click -> Run all tests

## Sample program output
```
The deck is being shuffled...

The cards are being dealt to 2 players <<-- There are 2 players in the game Player1 & Player2

Player1 has: 
One Pair or Two of a Kind on 1st 2 cards <<-- Shows best possible case in the current set of cards received by player1
Player2 has: 
high card <<-- Shows best possible case in the current set of cards received by player2

Player1 players cards:
Ace of DIAMONDS, Ace of HEARTS, Queen of CLUBS, 9 of DIAMONDS, 7 of HEARTS <<-- Displays all the cards held by payer1 currently

Player2 players cards:
King of CLUBS, 9 of HEARTS, 7 of DIAMONDS, 5 of CLUBS, 2 of SPADE <<-- Displays all the cards held by payer2 currently

-----------------------------------

Winner is: 
Player1 <<-- Winner of this round
Ace of DIAMONDS, Ace of HEARTS, Queen of CLUBS, 9 of DIAMONDS, 7 of HEARTS

-----------------------------------
```
