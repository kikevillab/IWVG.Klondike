package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.utils.IO;


public class TableauToFoundationController extends MoveController {

    private int numTableau, numFoundation;

    public TableauToFoundationController() {
        super();
    }

    @Override
    public void control() {
    	IO io = new IO();
        int numTableau = io.readInt("¿De qué escalera? [1-7]:");
        while (numTableau < 1 || numTableau > 7) {
            io.writeln("ERROR!!! El número de la escalera debe ser entre 1 y 7 inclusives");
            numTableau = io.readInt("¿De qué escalera? [1-7]:");
        }
        int numFoundation = io.readInt("¿A qué palo? [1-4]:");
        while (numFoundation < 1 || numFoundation > 4) {
            io.writeln("ERROR!!! El número del palo debe ser entre 1 y 4 inclusives");
            numFoundation = io.readInt("¿A qué palo? [1-4]:");
        }
        setNumFoundation(numFoundation - 1);
        setNumTableau(numTableau - 1);
    	
        TableauPiles tableauOrigin = game.getTableauPile(this.numTableau);
        if (tableauOrigin.isEmpty()) {
            System.out.println(ErrorEnum.TABLEAU_EMPTY);
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
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            } else if (!game.getFoundation(numFoundation).getLastCard().validAboveFoundation(game.getTableauPile(numFoundation).getLastCard())) {
                return new Error(game.getTableauPile(numTableau).getLastCard(), game.getFoundation(numFoundation).getLastCard());
            }
            return null;
        }
        if (game.isFoundationEmpty(numFoundation)){
           return new Error(ErrorEnum.NOT_VALID_MOVE);
        }else{
            return new Error(game.getTableauPile(numTableau).getLastCard(), game.getFoundation(numFoundation).getLastCard());
        }    
    }

    public void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }

    public Error checkFaceUpCard(TableauPiles tableau) {
        if (tableau.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorEnum.NO_FACEUP_CARDS);
    }


}
