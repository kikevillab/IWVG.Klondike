package e.arranz.miw_upm.klondike.models;

public enum Color {

    BLACK("B"), 
    RED("R");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    public int position() {
        return this.ordinal() + 1;
    }

    public String getValue() {
        return value;
    }

}
