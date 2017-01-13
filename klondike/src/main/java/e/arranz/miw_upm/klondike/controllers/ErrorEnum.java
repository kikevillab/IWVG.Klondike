package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.Card;


public enum ErrorEnum {
	
	NOT_VALID_MOVE("ERROR!  No se puede colocar esa carta en esa posición"),
	NOT_ENOUGH_CARDS("ERROR!  No se pueden coger más cartas de las que hay en un montón"),
	DECK_EMPTY("ERROR!  La baraja está vacía"),
	FOUNDATION_EMPTY("ERROR!  El palo está vacío"),
	TABLEAU_EMPTY("ERROR!  La escalera está vacía"),
	FLIPCARD_ERROR("ERROR!  No hay ninguna carta descubierta para descubrir"),
	EXISTS_FACEUP_CARDS("ERROR!  No se puede voltear una carta descubierta"),
	WASTE_EMPTY("ERROR!  El descarte está vacío"),
    NO_FACEUP_CARDS("ERROR!  No hay ninguna carta descubierta para mover"),
    NO_FACEDOWN_CARDS("ERROR!  No hay ninguna carta oculta para descubrir");
    
	private String message;
	
	private ErrorEnum(String message){
		this.message = message;
	}
	
	private ErrorEnum(Card cardUp, Card cardDown){
        this.message="ERROR!  No se puede poner "+cardUp.toString()+" sobre "+cardDown.toString();
    }
	
	@Override
	public String toString(){
		return message;
	}
}
