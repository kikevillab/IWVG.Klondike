package e.arranz.miw_upm.klondike.controllers;


public class DeckToWasteController extends MoveController {

    private static final int MAX_CARDS_DISCARD = 3;

    public DeckToWasteController() {
        super();
    }

    @Override
    public void control() {
        Error error = validateMove();
        if (error != null) {
            System.out.println(error);
        } else {
            for (int i = 0; i < MAX_CARDS_DISCARD; i++) {
                if (validateMove() != null) {
                	break;                    
                } 
                
                game.addCardWaste(game.popCardDeck());
            }
            game.setWasteDisplaySize(MAX_CARDS_DISCARD);
        }
    }

    @Override
    public Error validateMove() {
        if (game.isDeckEmpty()) {
            return new Error(ErrorList.DECK_EMPTY);
        }
        return null;
    }

   

}
