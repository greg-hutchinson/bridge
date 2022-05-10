package bridge

import ca.attractors.deck.Card

class Distributor {
    Closure deck;
    long count = 0
    long iterations = 100000
    Closure<Distributor> setUp
    Closure<Distributor> condition
    List<Card> cards
    List<Card> north = new ArrayList<Card>()
    List<Card> east = new ArrayList<Card>()
    List<Card> south = new ArrayList<Card>()
    List<Card> west = new ArrayList<Card>()

    public Distributor() {
        setDeck {
            def cards = Card.getAllCards()
            Collections.shuffle(cards)
            cards
        }
        setSetUp {}
        setCondition {false}
    }

    public void simulate() {
        for (long i=0; i<iterations;i++) {
            initialize()
            if (condition(this))
                count++
        }
        println("The value is ${count * 100 / iterations}")
    }

    private void initialize() {
        cards = deck()
        north = new Hand()
        east = new Hand()
        south = new Hand()
        west = new Hand()
        setUp(this)
        deal()
    }

    def void fillNorth() {
        while (north.size() < 13) {
            north.add(cards.remove(0))
        }
    }
    def void fillSouth() {
        while (south.size() < 13) {
            south.add(cards.remove(0))
        }
    }


    def void deal() {
        def compass = [north, east, south, west]
        compass.each {
            while (it.size() < 13) {
                it.add(cards.remove(0))
            }
        }
    }

    void addNorthCards(Card[] aCards) {
        cards.removeAll(aCards)
        north.addAll(aCards)
    }
    void addSouthCards(Card[] aCards) {
        cards.removeAll(aCards)
        south.addAll(aCards)
    }
    void addWest(Card aCard) {
        cards.remove(aCard)
        west.add(aCard)
    }
    void addEast(Card aCard) {
        cards.remove(aCard)
        east.add(aCard)
    }

    def void setDeck(Closure aClosure) {
        deck = aClosure
    }
}
