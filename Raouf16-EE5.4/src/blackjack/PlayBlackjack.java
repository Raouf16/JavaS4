package blackjack;

import card_library.*;
import text_library.*;
/**
 * This class is built to test the BlackJackand class. 
 * It contains the main function used to launch the program.
 */
public class PlayBlackjack {
	/*
	 * Main function. Definitely the place to be
	 */
	public static void main(String[] args) {
		
	    int randomCardNumber;                     //initializes the number of card to pick
	    int cpt = 0;                              //just a cpt
		BlackjackHand hand = new BlackjackHand(); //initializes the hand	
		Deck deck = new Deck(false);              //generates the deck
		char responseChar = 'Y';				  //User's Response
		
		//Until User wants to quit
		do{
			
			TextIO textObject = new TextIO();
			randomCardNumber = (int)(Math.random()*5) + 2; //get a random number between 2 and 6 (2<=number<5+2)
			System.out.println("Number Of Cards : " + randomCardNumber);
			System.out.println("---------------------------------------");
			//choose a card from the deck and put it in the Hand 
			do{
				deck.shuffle();
				Card card = new Card();
				card = deck.dealCard();		//pick the card		
				hand.addCard(card);			//add the card to the hand
				System.out.println(card);	//Print the card value
				cpt++;
			}while(cpt < randomCardNumber);	
			//Let's play	
			System.out.println("Blackjack Hand's Value : " + hand.getBlackjackValue());
			System.out.println();
			//Continue or not
			do{
				System.out.println("Do you want to play again? (Y/N) " );
				responseChar = textObject.getlnChar();
				responseChar = Character.toUpperCase(responseChar);
			}while(responseChar != 'Y' && responseChar != 'N');	
			//Clean the house for next round
			hand.clear();
			cpt = 0;	
		}while(responseChar != 'N');
		System.out.println("*********** GAME OVER ***********");

	}// End main()

}// End class PlayBlackjack
