package bridge

import ca.attractors.deck.Card


class Hand {
    @Delegate
    List<Card> cards = new ArrayList<Card>()

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
}
