/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package bridge

import ca.attractors.deck.Card
import ca.attractors.deck.Suit
import ca.attractors.deck.Value
import org.junit.jupiter.api.Test

import static ca.attractors.deck.Card.*
import static ca.attractors.deck.Suit.*

class SimulatorDeckTest {
    @Test
    void testX() {
        def deck = new SimulatorDeck()
        deck.reserve(DeuceOfSpades, KingOfSpades)
        def north = deck.remove(5, Suit.SPADES) { Card potential ->
            potential != DeuceOfSpades && potential != KingOfSpades
        }
        deck.fill(north, 13)
        def south = deck.remove(6, Suit.SPADES) { Card potential ->
            potential != DeuceOfSpades && potential != KingOfSpades
        }
        deck.fill(south, 13)
        deck.unreserveAll()
        println (north)
        println (south)
    }

}