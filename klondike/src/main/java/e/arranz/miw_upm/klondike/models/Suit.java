package e.arranz.miw_upm.klondike.models;

public enum Suit {

    CORAZONES("c"), 
    DIAMANTES("d"), 
    TREBOLES("t"), 
    PICAS("p");

    private String value;

    private Suit(String value) {
        assert value != null;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public Color getColor(){
    	if(this.equals(Suit.CORAZONES) || this.equals(Suit.DIAMANTES))
    		return Color.RED;
    	else
    		return Color.BLACK;
    }

}
