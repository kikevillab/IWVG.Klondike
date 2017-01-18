package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Error;
import e.arranz.miw_upm.klondike.models.State;


public abstract class MoveController extends OperationController {

    @Override
    public void control() {
        if (game.isGameFinalized()) {
            game.setState(State.FINISHED);
        }
    }

    abstract Error validateMove();


}
