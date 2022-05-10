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
        north = new ArrayList<Card>()
        east = new ArrayList<Card>()
        south = new ArrayList<Card>()
        west = new ArrayList<Card>()
        setUp(this)
        deal()
    }

    def void deal() {
        def compass = [north, east, south, west]
        compass.each {
            while (it.size() < 13) {
                it.add(cards.remove(0))
            }
        }
    }

    void addNorth(Card aCard) {
        cards.remove(aCard)
        north.add(aCard)
    }
    void addWest(Card aCard) {
        cards.remove(aCard)
        west.add(aCard)
    }
    void addSouth(Card aCard) {
        cards.remove(aCard)
        south.add(aCard)
    }
    void addEast(Card aCard) {
        cards.remove(aCard)
        east.add(aCard)
    }

    def void setDeck(Closure aClosure) {
        deck = aClosure
    }
}
