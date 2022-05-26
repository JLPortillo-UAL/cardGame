package org.hmis.cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/* 
    An object of type Deck represents an ordinary deck of 52 playing cards.
    The deck can be shuffled, and cards can be dealt from the deck.
    
    Source: https://math.hws.edu/eck/cs124/javanotes4/c5/ex-5-5-answer.html
 */

public class Deck2 {

	private Card[] deck; // An array of 52 Cards, representing the deck.

	private int cardsUsed; // How many cards have been dealt from the deck.

	public Deck2() throws FileNotFoundException {
		// Create an unshuffled deck of cards.
		File doc = new File(
				"C:\\Users\\josel\\git\\cardGame\\src\\org\\hmis\\cardGame\\initialDeckLectura.txt");
		Scanner obj = new Scanner(doc);
		int cont = 0;
		int palo = 0;
		deck = new Card[52];
		int cardCt = 0; // How many cards have been created so far.
		while (obj.hasNextLine()) {
			if (cont == 13) {
				cont = 0;
				palo++;
			} else {
				deck[cardCt] = new Card(Integer.parseInt(obj.nextLine()), palo);
				cardCt++;
			}
		}
		cardsUsed = 0;
	}

	public void shuffle() {
		// Put all the used cards back into the deck, and shuffle it into
		// a random order.
		for (int i = 51; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardsUsed = 0;
	}

	@Override
	public String toString() {
		String result = ""; // = "Deck \n";
		for (int i = 0; i < deck.length; i++) {
			result = result + deck[i].toString();
			if ((i + 1) % 13 == 0) {
				result = result + "\n";
			} else {
				result = result + "\t";
			}
		}

		return result;
	}

	public int cardsLeft() {
		// As cards are dealt from the deck, the number of cards left
		// decreases. This function returns the number of cards that
		// are still left in the deck.
		return 52 - cardsUsed;
	}

	public Card dealCard() {
		// Deals one card from the deck and returns it.
		
		cardsUsed++;
		return deck[cardsUsed - 1];
	}

} // end class Deck