package e.arranz.miw_upm.klondike.view;

import e.arranz.miw_upm.klondike.controllers.MenuController;
import e.arranz.miw_upm.klondike.controllers.OperationController;
import e.arranz.miw_upm.klondike.controllers.OperationControllerBuilder;
import e.arranz.miw_upm.klondike.utils.IO;
import e.arranz.miw_upm.klondike.utils.LimitedIntDialog;


public class MenuView {
    private MenuController menuController;

    private OperationControllerBuilder operationControllerBuilder;

    public MenuView() {
        menuController = new MenuController();
        operationControllerBuilder = new OperationControllerBuilder();
        operationControllerBuilder.build();
    }

    public void showStatus() {
        IO io = new IO();
        io.writeln("===========================");
        io.writeln("Baraja: " + menuController.getDeck());
        io.writeln("Descarte: " + menuController.getWaste());
        io.writeln("Palo corazones: " + menuController.getFoundation(0));
        io.writeln("Palo diamantes: " + menuController.getFoundation(1));
        io.writeln("Palo tréboles: " + menuController.getFoundation(2));
        io.writeln("Palo picas: " + menuController.getFoundation(3));
        for(int i = 0; i < 7; i++){
        	io.writeln("Escalera "+(i+1)+": " + menuController.getTableauPile(i));
        }      
        
        io.writeln("===========================");
    }

    public void showMenu() {
        IO io = new IO();
        io.writeln("1. Mover de baraja a descarte");
        io.writeln("2. Mover de descarte a baraja");
        io.writeln("3. Mover de descarte a palo");
        io.writeln("4. Mover de descarte a escalera");
        io.writeln("5. Mover de escalera a palo");
        io.writeln("6. Mover de escalera a escalera");
        io.writeln("7. Mover de palo a escalera");
        io.writeln("8. Voltear en escalera");
        io.writeln("9. Salir");
    }

    public OperationController interact() {
        showStatus();
        showMenu();
        int numOption = new LimitedIntDialog("Opción?", 1, 9).read();
        return operationControllerBuilder.getOperationController(numOption);
    }
}
