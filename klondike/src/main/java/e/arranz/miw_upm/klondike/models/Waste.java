package e.arranz.miw_upm.klondike.models;

import java.util.List;

public class Waste extends CardStack {

    private int size = 3;

    public Waste() {
        super();
    }

    public void setDisplaySize(int size) {
        this.size = size;
    }

    @Override
    public Card popCard() {
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
        } 
        if (cards.size() < size) {
            return cards.toString();
        } else {
            List<Card> lastCards = cards.subList(cards.size() - size, cards.size());
            return lastCards.toArray().toString();
        }
        
    }
}
