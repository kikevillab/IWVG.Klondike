package e.arranz.miw_upm.klondike.models;

public class Card {
    private CardValue value;

    private Color color;

    private Suit suit;

    public Card(CardValue value, Suit suit) {
        assert value != null;
        assert suit != null;
        this.value = value;
        this.suit = suit;
        if (suit.equals(Suit.CORAZONES) || suit.equals(Suit.DIAMANTES)) {
            this.color = Color.RED; 
        } else {
            this.color = Color.BLACK;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }

    public String getColor() {
        return color.getValue();
    }

    public boolean hasValue(String value) {
        assert value != null;
        return this.value.getValue() == value;
    }

    public boolean equalColor(Card card) {
        assert card != null;
        return card.getColor() == color.getValue();
    }

    public boolean equalSuit(Suit suit) {
        assert suit != null;
        return suit.getValue() == this.suit.getValue();
    }

    public boolean validAboveTableau(Card card) {
        assert card != null;
        return !this.equalColor(card) && card.isNextCardValue(this);
    }

    public boolean validAboveFoundation(Card card) {
        assert card != null;
        return this.equalColor(card) && this.isNextCardValue(card);
    }

    public boolean isNextCardValue(Card card) {
        assert card != null;
        return value.next() == card.getValue();
    }

    @Override
    public String toString() {
        return "[" + value.getValue() + "," + suit.getValue() + "]";
    }
}
