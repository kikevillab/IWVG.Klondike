package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.utils.IO;


public class FoundationToTableauController extends MoveController {

    private int numTableau, numFoundation;

    public FoundationToTableauController() {
        super();
    }

    @Override
    public void control() {
    	IO io = new IO();
        int numFoundation = io.readInt("¿De qué palo? [1-4]:");
        while (numFoundation < 1 || numFoundation > 4) {
            io.writeln("ERROR!!! El número del palo debe ser entre 1 y 4 inclusives");
            numFoundation = io.readInt("¿De qué palo? [1-4]:");
        }
        int numTableau = io.readInt("¿A qué escalera? [1-7]:");
        while (numTableau < 1 || numTableau > 7) {
            io.writeln("ERROR!!! El número de la escalera debe ser entre 1 y 7 inclusives");
            numTableau = io.readInt("¿A qué escalera? [1-7]:");
        }   
        
        setNumTableau(numTableau - 1);
        setNumFoundation(numFoundation -1);
    	
        TableauPiles tableau = game.getTableauPile(this.numTableau);
        if (game.getFoundation(this.numFoundation).isEmpty()) {
            System.out.println(ErrorEnum.FOUNDATION_EMPTY);
        } else if (checkFaceUpCard(tableau) != null) {
            System.out.println(checkFaceUpCard(tableau));
        } else if (validateMove() != null) {
            System.out.println(validateMove());
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
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            }
        } else if (!tableau.getLastCard().validAboveTableau(game.getFoundation(numFoundation).getLastCard())) {
            return new Error(game.getFoundation(numFoundation).getLastCard(), tableau.getLastCard());
        }
        return null;
    }

    public Error checkFaceUpCard(TableauPiles tableau) {
        if (tableau.isEmpty()) {
            return null;
        } else {
            if (tableau.hasFaceUpCards()) {
                return null;
            }
            return new Error(ErrorEnum.NO_FACEUP_CARDS);
        }
    }

    public void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }


}
