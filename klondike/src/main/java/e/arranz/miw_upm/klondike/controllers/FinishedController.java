package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.State;
import e.arranz.miw_upm.klondike.utils.IO;


public class FinishedController extends OperationController {

    public FinishedController() {
        super();
    }

    @Override
    public void control() {
    	new IO().writeln("Has ganado!");
        game.setState(State.FINISHED);
    }


}
