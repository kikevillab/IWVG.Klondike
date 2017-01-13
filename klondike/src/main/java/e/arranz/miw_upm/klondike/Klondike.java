package e.arranz.miw_upm.klondike;

import e.arranz.miw_upm.klondike.controllers.OperationController;


public class Klondike {

    private Logic logic;

    public Klondike(Logic logic) {
        this.logic = logic;
    }

    public void play() {
         OperationController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
            	controller.control();
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Klondike(new Logic()).play();
    }
}
