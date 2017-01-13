package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Game;


public abstract class OperationController implements ControllerInterface {

    protected Game game;
    
    protected OperationController() {
        game = Game.getInstance();
    }
    
    public abstract void control();

}
