package e.arranz.miw_upm.klondike.controllers;

public class OperationControllerBuilder {

    private OperationController[] operationsController;

    private static final int NUM_OPTIONS = 9;

    public OperationControllerBuilder() {
    	operationsController = new OperationController[NUM_OPTIONS];
    }
    
    public void build(){
    	operationsController[0] = new DeckToWasteController();
    	operationsController[1] = new WasteToDeckController();
    	operationsController[2] = new WasteToFoundationController();
    	operationsController[3] = new WasteToTableauController();
    	operationsController[4] = new TableauToFoundationController();
    	operationsController[5] = new TableauToTableauController();
    	operationsController[6] = new FoundationToTableauController();
    	operationsController[7] = new FlipCardController();
    	operationsController[8] = new ExitController();
 
    }
    
    public OperationController getOperationController(int option){
    	return operationsController[option - 1];
    }
}
