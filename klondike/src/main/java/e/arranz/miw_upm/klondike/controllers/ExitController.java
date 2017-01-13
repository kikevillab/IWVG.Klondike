package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.models.State;
import e.arranz.miw_upm.klondike.utils.IO;

public class ExitController extends OperationController {

    public ExitController() {
        super();
    }

    @Override
    public void control() {
    	IO io = new IO();
        String answer = io.readString("¿Estás seguro de terminar el juego? (n-no, s-sí)");
        
        while (!answer.equalsIgnoreCase("n") && !answer.equalsIgnoreCase("s")) {
            io.writeln("Por favor, introduzca una opción válida.");
            io.readInt("¿Estás seguro de terminar el juego? (n-no, s-sí)");
        }
        if (answer.equalsIgnoreCase("s")) {
            io.writeln("Adios!!!");
            game.end();
            game.setState(State.EXIT);
        }  	
        
    }


}
