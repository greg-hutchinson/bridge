package bridge

import ca.attractors.deck.Card


class Hand {
    @Delegate
    List<Card> cards = new ArrayList<Card>()

    public Hand(List<Card> cards) {
        this.cards = cards
    }

    def addAll(Hand aHand) {
        cards.addAll(aHand.getCards())
    }

    def boolean containsAll(Card... cards) {
        for (Card card: cards) {
            if (!contains(card))
                return false
        }
        return true
    }

    def boolean containsNone(Card... cards) {
        for (Card card: cards) {
            if (contains(card))
                return false
        }
        return true
    }

    def void fillFromDeck(SimulatorDeck simulatorDeck) {
        while(size() <= 13) {
            cards.add(simulatorDeck.getNextCard())
        }
    }
}
