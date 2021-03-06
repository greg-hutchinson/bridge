package ca.attractors.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

import ca.attractors.images.ImageLoader;

public class Deck {
	public Deck() {
		cards.addAll(Card.getAllCards());
	}

	private List<Card> cards = new ArrayList<Card>();

	public int getSize() {
		return cards.size();
	}

	public Card getNextCard() {
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	public ImageIcon getImageIcon() {
		return new ImageLoader(getImageFilename()).getImageIcon();
	}

	public String getImageFilename() {
		return "Deck.JPG";
	}


}
