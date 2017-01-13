package e.arranz.miw_upm.klondike.view;

import e.arranz.miw_upm.klondike.controllers.MenuController;
import e.arranz.miw_upm.klondike.controllers.OperationController;
import e.arranz.miw_upm.klondike.controllers.OperationControllerBuilder;
import e.arranz.miw_upm.klondike.utils.IO;


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
        io.write("Baraja: ");
        io.writeln(menuController.getDeck());
        io.write("Descarte: ");
        io.writeln(menuController.getWaste());
        io.write("Palo corazones: ");
        io.writeln(menuController.getFoundation(0));
        io.write("Palo diamantes: ");
        io.writeln(menuController.getFoundation(1));
        io.write("Palo tréboles: ");
        io.writeln(menuController.getFoundation(2));
        io.write("Palo picas: ");
        io.writeln(menuController.getFoundation(3));
        io.write("Escalera 1: ");
        io.writeln(menuController.getTableauPile(0));
        io.write("Escalera 2: ");
        io.writeln(menuController.getTableauPile(1));
        io.write("Escalera 3: ");
        io.writeln(menuController.getTableauPile(2));
        io.write("Escalera 4: ");
        io.writeln(menuController.getTableauPile(3));
        io.write("Escalera 5: ");
        io.writeln(menuController.getTableauPile(4));
        io.write("Escalera 6: ");
        io.writeln(menuController.getTableauPile(5));
        io.write("Escalera 7: ");
        io.writeln(menuController.getTableauPile(6));
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
        IO io = new IO();
        int numOption = io.readInt("Opción? [1-9]:");
        while ((numOption > 9) || (numOption < 1)) {
            if ((numOption > 9) || (numOption < 1)) {
                io.writeln("ERROR! La opción debe ser entre 1 y 9 inclusives");
            }
            numOption = io.readInt("Opción? [1-9]:");
        }
        return operationControllerBuilder.getOperationController(numOption);
    }
}
