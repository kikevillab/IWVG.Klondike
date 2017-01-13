package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Deck;
import e.arranz.miw_upm.klondike.models.Foundation;
import e.arranz.miw_upm.klondike.models.State;
import e.arranz.miw_upm.klondike.models.Suit;
import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.models.Waste;

public class StartController extends OperationController {

    public StartController() {
        super();
    }

    private void createTableauPiles() {
        for (int i = 0; i < TableauPiles.NUMBER_OF_PILES; i++) {
            TableauPiles tableau = new TableauPiles();
            for (int j = 0; j < i; j++) {
                tableau.addCardFaceDown(game.popCardDeck());
            }
            tableau.addCardFaceUp(game.popCardDeck());
            game.addTableauPile(tableau);

        }
    }

    private void createFoundations() {
        for (Suit suit : Suit.values()) {
            game.addFoundation(new Foundation(suit));
        }
    }

    @Override
    public void control() {
        game.setDeck(new Deck());
        game.setWaste(new Waste());
        createTableauPiles();
        createFoundations();
        game.setState(State.IN_GAME);

    }

}
