package e.arranz.miw_upm.klondike.controllers;

import e.arranz.miw_upm.klondike.utils.ClosedIntervalString;
import e.arranz.miw_upm.klondike.utils.IO;
import e.arranz.miw_upm.klondike.utils.LimitedStringDialog;

public class ExitController extends OperationController {

    public ExitController() {
        super();
    }

    @Override
    public void control() {
    	IO io = new IO();
    	String[] limits = {"s", "n"};    	
        String answer = new LimitedStringDialog("¿Estás seguro de terminar el juego? (s/n)", new ClosedIntervalString(limits)).read();
 
        if (answer.equalsIgnoreCase("s")) {
            io.writeln("Adios!!!");
            game.end();
        }  	
        
    }


}
