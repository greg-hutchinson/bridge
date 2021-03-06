/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package bridge


import org.junit.jupiter.api.Test;
import static ca.attractors.deck.Card.*


class CardHandSimulatorTest {
    @Test void testX() {
        def distributor = new CardHandSimulator()
        def setup = { CardHandSimulator distributor1 ->
            def cards = distributor.getCards()
            cards.remove(KingOfSpades)
            cards.remove(DeuceOfSpades)
            distributor.addNorthCards(AceOfSpades, QueenOfSpades, JackOfSpades, NineOfSpades, EightOfSpades)
            distributor.addSouthCards(TenOfSpades, ThreeOfSpades, FourOfSpades, FiveOfSpades, SixOfSpades, SevenOfSpades)
            distributor.fillNorth()
            distributor.fillSouth()
            cards.add(KingOfSpades)
            cards.add(DeuceOfSpades)
            Collections.shuffle(cards)
        }

//        distributor.setCondition {
//            it.getEast().containsAll(getKingOfSpades(),getDeuceOfSpades()) || it.getEast().containsNone(getKingOfSpades(), getDeuceOfSpades())
//        }
        distributor.setCondition {
            it.getEast().contains(getKingOfSpades()) && !(it.getEast().contains(getDeuceOfSpades()))
        }
        distributor.setSetUp(setup)
        distributor.simulate()
    }
}
