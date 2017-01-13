package e.arranz.miw_upm.klondike.models;

import java.util.List;

public class Waste extends CardStack {

    private int size = 3;

    public Waste() {
        super();
    }

    public void setDisplaySize(int size) {
        assert size > 0;
        assert size < 4;
        this.size = size;
    }

    @Override
    public Card popCard() {
        assert cards.isEmpty() == false;
        if (size == 1) {
            size = 3;
        } else {
            size--;
        }
        return cards.pop();
    }

    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "<vacío>";
        } else {
            if (cards.size() < size) {
                return toStringCardList(cards);
            } else {
                List<Card> lastCards = cards.subList(cards.size() - size, cards.size());
                return toStringCardList(lastCards);
            }
        }
    }

    public String toStringCardList(List<Card> cards) {
        String toString = "";
        for (Card card : cards) {
            toString += card.toString();
        }
        return toString;
    }
}
