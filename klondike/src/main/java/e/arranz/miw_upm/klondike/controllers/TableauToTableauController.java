package e.arranz.miw_upm.klondike.controllers;

import java.util.Stack;

import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.models.Card;
import e.arranz.miw_upm.klondike.utils.LimitedIntDialog;

public class TableauToTableauController extends MoveController {

    private int numTableauTarget, numTableauOrigin, numCards;

    public TableauToTableauController() {
        super();
    }

    @Override
    public void control() {
        setNumTableauOrigin(new LimitedIntDialog("¿De qué escalera?", 1, 7).read() - 1);
        setNumCards(new LimitedIntDialog("¿Cuántas cartas?", 1, 12).read());
        setNumTableauTarget(new LimitedIntDialog("¿A qué escalera?", 1, 7).read() - 1);
    	    	
        TableauPiles tableauOrigin = game.getTableauPile(this.numTableauOrigin);
        TableauPiles tableauTarget = game.getTableauPile(this.numTableauTarget);
        if (tableauOrigin.isEmpty()) {
            System.out.println(ErrorList.TABLEAU_EMPTY);
        } else if (checkFaceUpCard(tableauOrigin) != null) {
            System.out.println(checkFaceUpCard(tableauOrigin));
        } else if (checkFaceUpCard(tableauTarget) != null) {
            System.out.println(checkFaceUpCard(tableauTarget));
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            Stack<Card> stackAux = new Stack<Card>();
            for (int i = 0; i < numCards; i++) {
                stackAux.push(tableauOrigin.popCard());
            }
            while (!stackAux.isEmpty()) {
                tableauTarget.addCardFaceUp(stackAux.pop());
            }
        }
    }

    @Override
    public Error validateMove() {
        TableauPiles tableauOrigin = game.getTableauPile(numTableauOrigin);
        TableauPiles tableauTarget = game.getTableauPile(numTableauTarget);
        if (tableauTarget.isEmpty()) {
            if (tableauOrigin.getFaceUpCard(numCards - 1).hasValue("K")) {
                return null;
            } else {
                return new Error(ErrorList.NOT_VALID_MOVE);
            }
        } else {
            if (tableauOrigin.getFaceUpCardsNumber() < numCards) {
                return new Error(ErrorList.NOT_ENOUGH_CARDS);
            } else if (!tableauTarget.getLastCard().validAboveTableau(tableauOrigin.getFaceUpCard(numCards))) {
                return new Error(tableauOrigin.getFaceUpCard(numCards), tableauTarget.getLastCard());
            }
        }
        return null;
    }

    private void setNumTableauOrigin(int numTableauOrigin) {
        this.numTableauOrigin = numTableauOrigin;
    }

    private void setNumTableauTarget(int numTableauTarget) {
        this.numTableauTarget = numTableauTarget;
    }
    
    private void setNumCards(int numCards){
    	this.numCards = numCards;
    }

    public Error checkFaceUpCard(TableauPiles tableau) {
        if (tableau.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorList.NO_FACEUP_CARDS);
    }

}
