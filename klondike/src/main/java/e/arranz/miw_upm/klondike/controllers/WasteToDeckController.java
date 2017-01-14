package e.arranz.miw_upm.klondike.controllers;



public class WasteToDeckController extends MoveController {

    public WasteToDeckController() {
        super();
    }

    @Override
    public void control() {
        Error error = validateMove();
        if (error != null) {
            System.out.println(error);
        }
        while (!game.isWasteEmpty()) {
            game.addCardDeck(game.popCardWaste());
        }
    }

    @Override
    public Error validateMove() {
        if (game.isWasteEmpty()) {
            return new Error(ErrorList.WASTE_EMPTY);
        }
        return null;
    }

}
