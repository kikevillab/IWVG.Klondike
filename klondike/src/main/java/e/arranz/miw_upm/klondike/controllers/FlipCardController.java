package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.TableauPiles;
import e.arranz.miw_upm.klondike.utils.IO;


public class FlipCardController extends MoveController {

    private int numTableau;

    public FlipCardController() {
        super();
    }

    @Override
    public void control() {
    	IO io = new IO();
        int numTableau = io.readInt("¿En qué escalera? [1-7]:");
        while (numTableau < 1 || numTableau > 7) {
            io.writeln("ERROR!!! El número de la escalera debe ser entre 1 y 7 inclusives");
            numTableau = io.readInt("¿En qué escalera? [1-7]:");
        }
        
        setNumTableau(numTableau -1);
           	
        TableauPiles tableau = game.getTableauPile(this.numTableau);
        Error error = validateMove();
        if (tableau.isEmpty()) {
            System.out.println(ErrorEnum.TABLEAU_EMPTY);
        } else if (validateMove() != null) {
            System.out.println(error);
        } else {
            tableau.flipCard();
        }
    }

    @Override
    public Error validateMove() {
        if (!game.getTableauPile(numTableau).hasFaceUpCards()) {
            if (!game.getTableauPile(numTableau).hasFaceDownCards()) {
                return new Error(ErrorEnum.NO_FACEDOWN_CARDS);
            } else {
                return null;
            }

        }
        return new Error(ErrorEnum.EXISTS_FACEUP_CARDS);
    }
    
    private void setNumTableau(int numTableau){
    	this.numTableau = numTableau;
    }



}
