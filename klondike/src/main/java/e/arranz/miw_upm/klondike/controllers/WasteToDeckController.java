package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Error;
import e.arranz.miw_upm.klondike.models.ErrorList;
import e.arranz.miw_upm.klondike.utils.IO;



public class WasteToDeckController extends MoveController {

    public WasteToDeckController() {
        super();
    }

    @Override
    public void control() {
        Error error = validateMove();
        if (error != null) {
        	new IO().writeln(error.toString());
        }
        while (!game.isWasteEmpty()) {
            game.addCardDeck(game.popCardWaste());
        }
    }

    @Override
    public Error validateMove() {
        if (game.isWasteEmpty()) {
            return new Error(ErrorList.WASTE_EMPTY);
        }
        return null;
    }

}
