package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Game;
import e.arranz.miw_upm.klondike.models.GameInterface;


public class MenuController {

    private GameInterface game;

    public MenuController() {
        game = Game.getGameInterfaceInstance();
    }

    public String getDeck() {
        return game.getDeckString();
    }

    public String getWaste() {
        return game.getWasteString();
    }

    public String getFoundation(int position) {
        return game.getFoundationString(position);
    }

    public String getTableauPile(int position) {
        return game.getTableauPileString(position);
    }

}
