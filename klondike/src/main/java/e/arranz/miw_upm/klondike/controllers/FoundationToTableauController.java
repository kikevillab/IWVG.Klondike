package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Error;
import e.arranz.miw_upm.klondike.models.ErrorList;
import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.utils.IO;
import e.arranz.miw_upm.klondike.utils.LimitedIntDialog;


public class FoundationToTableauController extends MoveController {

    private int numTableau, numFoundation;

    public FoundationToTableauController() {
        super();
    }

    @Override
    public void control() {        
        setNumTableau(new LimitedIntDialog("¿A qué escalera?", 1,7).read() - 1);
        setNumFoundation(new LimitedIntDialog("¿De qué palo?", 1, 4).read() -1);
    	
        TableauPiles tableau = game.getTableauPile(this.numTableau);
        if (game.getFoundation(this.numFoundation).isEmpty()) {
            new IO().writeln(ErrorList.FOUNDATION_EMPTY.toString());
        } else if (checkFaceUpCard(tableau) != null) {
        	new IO().writeln(checkFaceUpCard(tableau).toString());
        } else if (validateMove() != null) {
        	new IO().writeln(validateMove().toString());
        } else {
            tableau.addCardFaceUp(game.popCardFoundation(this.numFoundation));
        }
    }

    @Override
    public Error validateMove() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (tableau.isEmpty()) {
            if (game.getFoundation(numFoundation).getLastCard().hasValue("K")) {
                return null;
            } else {
                return new Error(ErrorList.NOT_VALID_MOVE);
            }
        } else if (!tableau.getLastCard().validAboveTableau(game.getFoundation(numFoundation).getLastCard())) {
            return new Error(game.getFoundation(numFoundation).getLastCard(), tableau.getLastCard());
        }
        return null;
    }

    public Error checkFaceUpCard(TableauPiles tableau) {
        if (tableau.isEmpty()) {
            return null;
        } 
        if (tableau.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorList.NO_FACEUP_CARDS);
        
    }

    private void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }

    private void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }


}
