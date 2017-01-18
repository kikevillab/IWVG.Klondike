package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Error;
import e.arranz.miw_upm.klondike.models.ErrorList;
import e.arranz.miw_upm.klondike.utils.IO;


public class DeckToWasteController extends MoveController {

    private static final int MAX_CARDS_DISCARD = 3;

    public DeckToWasteController() {
        super();
    }

    @Override
    public void control() {
        Error error = validateMove();
        if (error != null) {
        	new IO().writeln(error.toString());            
        } else {
            for (int i = 0; i < MAX_CARDS_DISCARD; i++) {
                if (validateMove() != null) {
                	break;                    
                } 
                
                game.addCardWaste(game.popCardDeck());
            }
            game.setWasteDisplaySize(MAX_CARDS_DISCARD);
        }
    }

    @Override
    public Error validateMove() {
        if (game.isDeckEmpty()) {
            return new Error(ErrorList.DECK_EMPTY);
        }
        return null;
    }

   

}
