package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Error;
import e.arranz.miw_upm.klondike.models.ErrorList;
import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.utils.IO;
import e.arranz.miw_upm.klondike.utils.LimitedIntDialog;


public class WasteToTableauController extends MoveController {

    private int numTableau;

    public WasteToTableauController() {
        super();
    }

    @Override
    public void control() {
        int numTableau = new LimitedIntDialog("¿A qué escalera?", 1, TableauPiles.NUMBER_OF_PILES).read();
        setNumTableau(numTableau - 1);
    	    	
        TableauPiles tableau = game.getTableauPile(this.numTableau);
        if (game.isWasteEmpty()) {
        	new IO().writeln(ErrorList.WASTE_EMPTY.toString());
        } else if (checkFaceUpCard(tableau) != null) {
        	new IO().writeln(checkFaceUpCard(tableau).toString());
        } else if (validateMove() != null) {
        	new IO().writeln(validateMove().toString());
        } else {
            tableau.addCardFaceUp(game.popCardWaste());
        }
    }

    @Override
    public Error validateMove() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (tableau.isEmpty()) {
            if (game.getLastCardWaste().hasValue("K")) {
                return null;
            } else {
                return new Error(ErrorList.NOT_VALID_MOVE);
            }
        } else if (!tableau.getLastCard().validAboveTableau(game.getLastCardWaste())) {
            return new Error(game.getLastCardWaste(), tableau.getLastCard());
        }
        return null;
    }

    public Error checkFaceUpCard(TableauPiles tableau) {
        if (tableau.hasFaceUpCards() || tableau.isEmpty()) {
            return null;
        }
        return new Error(ErrorList.FLIPCARD_ERROR);
    }

    private void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }


}
