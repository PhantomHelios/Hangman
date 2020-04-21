public class Card{
    private final char suit;
    private final String cardName;

    public Card(char suit, String cardName) {
        this.suit = suit;
        this.cardName = cardName;
    }

    public char getSuit() {
        return suit;
    }

    public String getCardName() {
        return cardName;
    }
}
