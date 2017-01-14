package e.arranz.miw_upm.klondike.models;

public class Card {
    private CardValue value;

    private Color color;

    private Suit suit;

    public Card(CardValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
        this.color = suit.getColor();
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
        return this.value.getValue() == value;
    }

    public boolean equalColor(Card card) {
        return card.getColor() == color.getValue();
    }

    public boolean equalSuit(Suit suit) {
        return suit.getValue() == this.suit.getValue();
    }

    public boolean validAboveTableau(Card card) {
        return !this.equalColor(card) && card.isNextCardValue(this);
    }

    public boolean validAboveFoundation(Card card) {
        return this.equalColor(card) && this.isNextCardValue(card);
    }

    public boolean isNextCardValue(Card card) {
        return value.next() == card.getValue();
    }

    @Override
    public String toString() {
        return "[" + value.getValue() + "," + suit.getValue() + "]";
    }
}
