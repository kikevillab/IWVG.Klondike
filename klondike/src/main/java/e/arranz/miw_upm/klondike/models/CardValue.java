package e.arranz.miw_upm.klondike.models;

public enum CardValue {

    ACE("A"), 
    TWO("2"), 
    THREE("3"), 
    FOUR("4"), 
    FIVE("5"), 
    SIX("6"), 
    SEVEN("7"), 
    EIGHT("8"), 
    NINE("9"), 
    TEN("10"), 
    JACK("J"), 
    QUEEN("Q"), 
    KING("K");

    private String value;

    private CardValue(String value) {
        this.value = value;
    }

    public CardValue next() {
        CardValue[] values = values();
        return values[(this.ordinal() + 1) % values.length];
    }
    
    public String getValue() {
        return value;
    }
}