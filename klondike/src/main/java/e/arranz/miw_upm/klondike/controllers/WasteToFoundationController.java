package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Error;
import e.arranz.miw_upm.klondike.models.ErrorList;
import e.arranz.miw_upm.klondike.utils.IO;
import e.arranz.miw_upm.klondike.utils.LimitedIntDialog;

public class WasteToFoundationController extends MoveController {

    private int numFoundation;

    public WasteToFoundationController() {
        super();
    }

    @Override
    public void control() {
    	int numFoundation = new LimitedIntDialog("¿A qué palo?", 1, 4).read();
        setNumFoundation(numFoundation - 1); 
    	
        if (game.isWasteEmpty()) {
        	new IO().writeln(ErrorList.WASTE_EMPTY.toString());
        } else if (validateMove() != null) {
        	new IO().writeln(validateMove().toString());
        } else {
            game.getFoundation(this.numFoundation).addCard(game.popCardWaste());
            super.control();
        }
    }

    @Override
    public Error validateMove() {
        if (game.getFoundation(numFoundation).equalSuit(game.getLastCardWaste())) {
            if (game.getFoundation(numFoundation).isEmpty()) {
                if (game.getLastCardWaste().hasValue("A")) {
                    return null;
                }
                return new Error(ErrorList.NOT_VALID_MOVE);
            } else if (!game.getFoundation(numFoundation).getLastCard().validAboveFoundation(game.getLastCardWaste())) {
                return new Error(game.getLastCardWaste(), game.getFoundation(numFoundation).getLastCard());
            }
            return null;
        } else if (game.getFoundation(numFoundation).isEmpty()){
            return new Error(ErrorList.NOT_VALID_MOVE);
        }else{
            return new Error(game.getLastCardWaste(), game.getFoundation(numFoundation).getLastCard());
        }
        
    }

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }


}
