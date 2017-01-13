package e.arranz.miw_upm.klondike.models;

import java.util.ArrayList;
import java.util.List;

public class Game implements GameInterface {

    private static Game game;

    private List<Foundation> foundations;

    private List<TableauPiles> tableauPiles;

    private Deck deck;

    private Waste waste;

    private State state;

    public Game() {
        state = State.INITIAL;
        this.foundations = new ArrayList<Foundation>();
        this.tableauPiles = new ArrayList<TableauPiles>();
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public static GameInterface getGameInterfaceInstance() {
        return game;
    }

    public State getState() {
        return state;
    }

    public TableauPiles getTableauPile(int position) {
        return tableauPiles.get(position);
    }
    
    public void addTableauPile(TableauPiles tableau) {
        this.tableauPiles.add(tableau);
    }

    public Foundation getFoundation(int position) {
        return foundations.get(position);
    }
    
    public void addFoundation(Foundation foundation) {
        this.foundations.add(foundation);
    }
    
    public boolean isFoundationEmpty(int position) {
        return getFoundation(position).isEmpty();
    }

    public void addCardWaste(Card card) {
        waste.addCard(card);
    }

    public void addCardDeck(Card card) {
        deck.addCard(card);
    }

    public Card getLastCardWaste() {
        return waste.getLastCard();
    }

    public Card popCardWaste() {
        return waste.popCard();
    }

    public Card popCardDeck() {
        return deck.popCard();
    }

    public Card popCardFoundation(int position) {
        return getFoundation(position).popCard();
    }

    public boolean isWasteEmpty() {
        return waste.isEmpty();
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    public boolean hasTableauFaceUpCards(int position) {
        return getTableauPile(position).isEmpty();
    }    

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    public boolean isGameFinalized() {
        int cards = 0;
        for (Foundation foundation : foundations) {
            cards += foundation.size();
        }
        return (Suit.values().length * CardValue.values().length) == cards;
    }

    public void setWasteDisplaySize(int size) {
        waste.setDisplaySize(size);
    }

    @Override
    public String getDeckString() {
        return deck.toString();
    }

    @Override
    public String getWasteString() {
        return waste.toString();
    }

    @Override
    public String getFoundationString(int position) {
        return getFoundation(position).toString();
    }

    @Override
    public String getTableauPileString(int position) {
        return getTableauPile(position).toString();
    }

    public void end() {
        deck.clear();
        waste.clear();
        for (TableauPiles tableauPile : tableauPiles) {
            tableauPile.clear();
        }
    }

}
