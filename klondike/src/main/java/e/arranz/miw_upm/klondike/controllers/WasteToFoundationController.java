package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.utils.IO;

public class WasteToFoundationController extends MoveController {

    private int numFoundation;

    public WasteToFoundationController() {
        super();
    }

    @Override
    public void control() {
    	IO io = new IO();
        int numFoundation = io.readInt("¿A qué palo? [1-4]:");
        while (numFoundation < 1 || numFoundation > 4) {
            io.writeln("ERROR!!! El número del palo debe ser entre 1 y 4 inclusives");
            numFoundation = io.readInt("¿A qué palo? [1-4]:");
        }
        setNumFoundation(numFoundation - 1);
 
    	
        if (game.isWasteEmpty()) {
            System.out.println(ErrorEnum.WASTE_EMPTY);
        } else if (validateMove() != null) {
            System.out.println(validateMove());
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
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            } else if (!game.getFoundation(numFoundation).getLastCard().validAboveFoundation(game.getLastCardWaste())) {
                return new Error(game.getLastCardWaste(), game.getFoundation(numFoundation).getLastCard());
            }
            return null;
        } else if (game.getFoundation(numFoundation).isEmpty()){
            return new Error(ErrorEnum.NOT_VALID_MOVE);
        }else{
            return new Error(game.getLastCardWaste(), game.getFoundation(numFoundation).getLastCard());
        }
        
    }

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }


}
