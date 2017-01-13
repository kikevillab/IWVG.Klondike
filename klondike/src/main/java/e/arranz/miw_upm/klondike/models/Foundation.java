package e.arranz.miw_upm.klondike.models;

public class Foundation extends CardStack {

    private Suit suit;

    public Foundation(Suit suit) {
        super();
        this.suit = suit;
    }

    public boolean equalSuit(Card card) {
        return card.equalSuit(suit);
    }

    @Override
    public String toString() {
        if (super.cards.isEmpty()) {
            return "<vacío>";
        } else {
            return super.cards.get(super.cards.size() - 1).toString();
        }
    }
    
}
