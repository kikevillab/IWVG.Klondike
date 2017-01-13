package e.arranz.miw_upm.klondike;

import e.arranz.miw_upm.klondike.controllers.FinishedController;
import e.arranz.miw_upm.klondike.controllers.OperationController;
import e.arranz.miw_upm.klondike.controllers.StartController;
import e.arranz.miw_upm.klondike.models.Game;
import e.arranz.miw_upm.klondike.view.MenuView;


public class Logic {

    private Game game;
    private MenuView menu;

    public Logic() {
        game = Game.getInstance();
        menu = new MenuView();
    }

    public OperationController getController() {
        switch (game.getState()) {
	        case INITIAL:
	            return new StartController();
	        case IN_GAME:
	            return menu.interact();
	        case FINISHED:
	            return new FinishedController();
	        default:
	            return null;
        }
    }
}
