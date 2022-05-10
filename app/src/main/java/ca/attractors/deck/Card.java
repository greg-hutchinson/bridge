package ca.attractors.deck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.ImageIcon;

import ca.attractors.images.ImageLoader;

public class Card implements Comparable<Card> {
	private Value value;
	private Suit suit;
	
	Card(Value aValue, Suit aSuit){
		value = aValue;
		suit = aSuit;
	}

	@Override
	public String toString() {
		return value.toString() + " of " + suit.toString();
	}
	
	public boolean isClub() {
		return suit == Suit.CLUBS;
	}
	public boolean isDiamond() {
		return suit == Suit.DIAMONDS;
	}
	public boolean isHeart() {
		return suit == Suit.HEARTS;
	}
	public boolean isSpade() {
		return suit == Suit.SPADES;
	}

	public Value getValue() {
		return value;
	}
	public Suit getSuit() {
		return suit;
	}


	public boolean isAce() {
		return getValue() == Value.ACE;
	}
	
	public boolean isFace() {
		if (getValue() == Value.KING)
			return true;
		if (getValue() == Value.QUEEN)
			return true;
		return getValue() == Value.JACK;
	}
	

	static Collection<Card> getAllCards() {
		List<Card> cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Value value: Value.values())
				cards.add(new Card(value,suit));
		}
		return cards;
	}
	
	public int RawValue() {
		return value.ordinal() + 1;
	}
	
	@Override
	public boolean equals(Object anOtherObject) {
		if (!(anOtherObject instanceof Card))
			return false;
		if (this == anOtherObject)
			return true;
		Card other = (Card) anOtherObject;
		if (suit != other.suit)
			return false;
		return value == other.value;
	}
	@Override
	public int hashCode() {
		return suit.hashCode() + value.hashCode();
	}
	
	protected Suit Suit() {
		return suit;
	}
	
	public int compareTo(Card anOtherCard) {
		if (this.equals(anOtherCard))
			return 0;
		if (suit != anOtherCard.suit)
			return suit.ordinal() - anOtherCard.suit.ordinal();
		return value.ordinal() - anOtherCard.value.ordinal();
	}

	public ImageIcon ImageIcon() {
		return new ImageLoader(ImageFilename()).getImageIcon();
	}

	public String ImageFilename() {
		String filename = Integer.toString(asIndex());
		if (asIndex() < 10)
			filename = "0" + filename;
		return filename + ".JPG";
	}
	
	private int asIndex() {
		int base = suit.ordinal() * 13; 
		return base + value.ordinal() + 1;
	}
    public static Card AceOfClubs = new Card(Value.ACE, Suit.CLUBS);
    public static Card DeuceOfClubs = new Card(Value.DEUCE, Suit.CLUBS);
    public static Card ThreeOfClubs = new Card(Value.THREE, Suit.CLUBS);
    public static Card FourOfClubs = new Card(Value.FOUR, Suit.CLUBS);
    public static Card FiveOfClubs = new Card(Value.FIVE, Suit.CLUBS);
    public static Card SixOfClubs = new Card(Value.SIX, Suit.CLUBS);
    public static Card SevenOfClubs = new Card(Value.SEVEN, Suit.CLUBS);
    public static Card EightOfClubs = new Card(Value.EIGHT, Suit.CLUBS);
    public static Card NineOfClubs = new Card(Value.NINE, Suit.CLUBS);
    public static Card TenOfClubs = new Card(Value.TEN, Suit.CLUBS);
    public static Card JackOfClubs = new Card(Value.JACK, Suit.CLUBS);
    public static Card QueenOfClubs = new Card(Value.QUEEN, Suit.CLUBS);
    public static Card KingOfClubs = new Card(Value.KING, Suit.CLUBS);

    public static Card AceOfDiamonds = new Card(Value.ACE, Suit.DIAMONDS);
    public static Card DeuceOfDiamonds = new Card(Value.DEUCE, Suit.DIAMONDS);
    public static Card ThreeOfDiamonds = new Card(Value.THREE, Suit.DIAMONDS);
    public static Card FourOfDiamonds = new Card(Value.FOUR, Suit.DIAMONDS);
    public static Card FiveOfDiamonds = new Card(Value.FIVE, Suit.DIAMONDS);
    public static Card SixOfDiamonds = new Card(Value.SIX, Suit.DIAMONDS);
    public static Card SevenOfDiamonds = new Card(Value.SEVEN, Suit.DIAMONDS);
    public static Card EightOfDiamonds = new Card(Value.EIGHT, Suit.DIAMONDS);
    public static Card NineOfDiamonds = new Card(Value.NINE, Suit.DIAMONDS);
    public static Card TenOfDiamonds = new Card(Value.TEN, Suit.DIAMONDS);
    public static Card JackOfDiamonds = new Card(Value.JACK, Suit.DIAMONDS);
    public static Card QueenOfDiamonds = new Card(Value.QUEEN, Suit.DIAMONDS);
    public static Card KingOfDiamonds = new Card(Value.KING, Suit.DIAMONDS);

    public static Card AceOfHearts = new Card(Value.ACE, Suit.HEARTS);
    public static Card DeuceOfHearts = new Card(Value.DEUCE, Suit.HEARTS);
    public static Card ThreeOfHearts = new Card(Value.THREE, Suit.HEARTS);
    public static Card FourOfHearts = new Card(Value.FOUR, Suit.HEARTS);
    public static Card FiveOfHearts = new Card(Value.FIVE, Suit.HEARTS);
    public static Card SixOfHearts = new Card(Value.SIX, Suit.HEARTS);
    public static Card SevenOfHearts = new Card(Value.SEVEN, Suit.HEARTS);
    public static Card EightOfHearts = new Card(Value.EIGHT, Suit.HEARTS);
    public static Card NineOfHearts = new Card(Value.NINE, Suit.HEARTS);
    public static Card TenOfHearts = new Card(Value.TEN, Suit.HEARTS);
    public static Card JackOfHearts = new Card(Value.JACK, Suit.HEARTS);
    public static Card QueenOfHearts = new Card(Value.QUEEN, Suit.HEARTS);
    public static Card KingOfHearts = new Card(Value.KING, Suit.HEARTS);

    public static Card AceOfSpades = new Card(Value.ACE, Suit.SPADES);
    public static Card DeuceOfSpades = new Card(Value.DEUCE, Suit.SPADES);
    public static Card ThreeOfSpades = new Card(Value.THREE, Suit.SPADES);
    public static Card FourOfSpades = new Card(Value.FOUR, Suit.SPADES);
    public static Card FiveOfSpades = new Card(Value.FIVE, Suit.SPADES);
    public static Card SixOfSpades = new Card(Value.SIX, Suit.SPADES);
    public static Card SevenOfSpades = new Card(Value.SEVEN, Suit.SPADES);
    public static Card EightOfSpades = new Card(Value.EIGHT, Suit.SPADES);
    public static Card NineOfSpades = new Card(Value.NINE, Suit.SPADES);
    public static Card TenOfSpades = new Card(Value.TEN, Suit.SPADES);
    public static Card JackOfSpades = new Card(Value.JACK, Suit.SPADES);
    public static Card QueenOfSpades = new Card(Value.QUEEN, Suit.SPADES);
    public static Card KingOfSpades = new Card(Value.KING, Suit.SPADES);

	
}
