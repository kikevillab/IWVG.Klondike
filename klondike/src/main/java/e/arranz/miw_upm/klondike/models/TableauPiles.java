package e.arranz.miw_upm.klondike.models;

import java.util.Stack;

public class TableauPiles {

    public static final int NUMBER_OF_PILES = 7;

    private Stack<Card> cardsFaceDown;

    private Stack<Card> cardsFaceUp;

    public TableauPiles() {
        this.cardsFaceDown = new Stack<Card>();
        this.cardsFaceUp = new Stack<Card>();
    }

    public boolean isEmpty() {
        return cardsFaceDown.isEmpty() && cardsFaceUp.isEmpty();
    }

    public Card getLastCard() {
        assert cardsFaceUp.isEmpty() == false;
        return cardsFaceUp.get(cardsFaceUp.size() - 1);
    }

    public void flipCard() {
        assert cardsFaceUp.isEmpty() == true;
        cardsFaceUp.push(cardsFaceDown.pop());
    }

    public Card popCard() {
        assert cardsFaceUp.isEmpty() == false;
        return cardsFaceUp.pop();
    }

    public int getFaceUpCardsNumber() {
        return cardsFaceUp.size();
    }

    public void addCardFaceUp(Card card) {
        assert card != null;
        cardsFaceUp.add(card);
    }

    public void addCardFaceDown(Card card) {
        assert card != null;
        cardsFaceDown.add(card);
    }

    public Card getFaceUpCard(int position) {
        assert position >= 0;
        assert position < cardsFaceUp.size();
        return cardsFaceUp.get(cardsFaceUp.size() - position);
    }

    public boolean hasFaceUpCards() {
        return !this.cardsFaceUp.isEmpty();
    }

    public boolean hasFaceDownCards() {
        return !this.cardsFaceDown.isEmpty();
    }

    public void clear() {
        cardsFaceUp = new Stack<Card>();
        cardsFaceDown = new Stack<Card>();
    }

    @Override
    public String toString() {
        if (cardsFaceDown.isEmpty() && cardsFaceUp.isEmpty()) {
            return "<vacío>";
        }
        String stringPileDown = "";
        for (int i = 0; i < cardsFaceDown.size(); i++) {
            stringPileDown += "[";
        }
        String stringPileUp = "";
        for (int i = 0; i < cardsFaceUp.size(); i++) {
            stringPileDown += cardsFaceUp.get(i);
        }
        return stringPileDown + stringPileUp;
    }
}
