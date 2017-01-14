package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.utils.LimitedIntDialog;

public class FlipCardController extends MoveController {

    private int numTableau;

    public FlipCardController() {
        super();
    }

    @Override
    public void control() {
        int numTableau = new LimitedIntDialog("¿En qué escalera?", 1, 7).read();
        setNumTableau(numTableau -1);
           	
        TableauPiles tableau = game.getTableauPile(this.numTableau);
        Error error = validateMove();
        if (tableau.isEmpty()) {
            System.out.println(ErrorList.TABLEAU_EMPTY);
        } else if (error != null) {
            System.out.println(error);
        } else {
            tableau.flipCard();
        }
    }

    @Override
    public Error validateMove() {
        if (game.getTableauPile(numTableau).hasFaceUpCards()) {
        	return new Error(ErrorList.EXISTS_FACEUP_CARDS);
        }
        if (!game.getTableauPile(numTableau).hasFaceDownCards()) {
            return new Error(ErrorList.NO_FACEDOWN_CARDS);
        }

        return null;
    }
    
    private void setNumTableau(int numTableau){
    	this.numTableau = numTableau;
    }



}
