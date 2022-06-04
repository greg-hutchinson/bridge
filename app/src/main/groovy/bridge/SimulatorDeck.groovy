package bridge

import ca.attractors.deck.Card
import ca.attractors.deck.Suit

class SimulatorDeck {
    private List<Card> cards = []
    private List<Card> reservedCards = []

    public SimulatorDeck() {
        cards.addAll(Card.getAllCards())
    }

    def void unreserveAll() {
        cards.addAll (reservedCards)
        reservedCards = []
    }

    def void reserve(Card ... cardsToReserve) {
        cardsToReserve.each {
            reservedCards << cards.remove(it)
        }
    }

    public int getSize() {
        return cards.size();
    }

    public Card getNextCard() {
        return cards.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    def Hand remove(int integer, Object o) {
        return remove(integer, o ) {
            true
        }
    }

    def Hand remove(int nCards, Suit suit, Closure<Void> shouldInclude) {
        int foundCards = 0
        int count = 0
        List<Card> validCards = []
        while(foundCards < nCards && count <= cards.size()){
            Card potential = cards.get(count)
            if (potential.getSuit() == suit && shouldInclude(potential)) {
                validCards << potential
                foundCards++
                cards.remove(potential)
            }
            else {
                count++
            }
        }
        if (validCards.size() != nCards)
            throw new IllegalStateException("Couldn't find enough cards to satisfy criteria")
        new Hand(validCards)
    }

    def void deal(int integer) {}

}
