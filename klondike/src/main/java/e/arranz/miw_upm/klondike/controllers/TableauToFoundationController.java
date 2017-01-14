package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.utils.LimitedIntDialog;


public class TableauToFoundationController extends MoveController {

    private int numTableau, numFoundation;

    public TableauToFoundationController() {
        super();
    }

    @Override
    public void control() {
        setNumFoundation(new LimitedIntDialog("¿A qué palo?", 1,4).read() - 1);
        setNumTableau(new LimitedIntDialog("¿De qué escalera?", 1,7).read() - 1);
    	
        TableauPiles tableauOrigin = game.getTableauPile(this.numTableau);
        if (tableauOrigin.isEmpty()) {
            System.out.println(ErrorList.TABLEAU_EMPTY);
        } else if (checkFaceUpCard(tableauOrigin) != null) {
            System.out.println(checkFaceUpCard(tableauOrigin));
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            game.getFoundation(this.numFoundation).addCard(game.getTableauPile(this.numTableau).popCard());
            super.control();
        }
    }

    @Override
    public Error validateMove() {
        if (game.getFoundation(numFoundation).equalSuit(game.getTableauPile(numTableau).getLastCard())) {
            if (game.getFoundation(numFoundation).isEmpty()) {
                if (game.getTableauPile(numTableau).getLastCard().hasValue("A")) {
                    return null;
                }
                return new Error(ErrorList.NOT_VALID_MOVE);
            } else if (!game.getFoundation(numFoundation).getLastCard().validAboveFoundation(game.getTableauPile(numFoundation).getLastCard())) {
                return new Error(game.getTableauPile(numTableau).getLastCard(), game.getFoundation(numFoundation).getLastCard());
            }
            return null;
        }
        if (game.isFoundationEmpty(numFoundation)){
           return new Error(ErrorList.NOT_VALID_MOVE);
        }else{
            return new Error(game.getTableauPile(numTableau).getLastCard(), game.getFoundation(numFoundation).getLastCard());
        }    
    }

    private void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }

    private void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }

    public Error checkFaceUpCard(TableauPiles tableau) {
        if (tableau.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorList.NO_FACEUP_CARDS);
    }


}
