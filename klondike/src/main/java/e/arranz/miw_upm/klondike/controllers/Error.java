package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Card;


public class Error {

    private String message;

    public Error(ErrorList error) {
        this.message = error.toString();
    }

    public Error(Card cardUp, Card cardDown) {
        this.message = "ERROR! No se puede poner " + cardUp.toString() + " sobre " + cardDown.toString();
    }

    @Override
    public String toString() {
        return message;
    }

}
