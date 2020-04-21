public class CardDeck {
    private final CircularQueue cards = new CircularQueue(52);

    public CardDeck(){
        String suits = "HSCD";
        for (int i = 0; i < 4; i++) {
            cards.enqueue(new Card(suits.charAt(i), "A"));
            for (int j = 2; j < 11; j++)
                cards.enqueue(new Card(suits.charAt(i), Integer.toString(j)));
            cards.enqueue(new Card(suits.charAt(i), "J"));
            cards.enqueue(new Card(suits.charAt(i), "K"));
            cards.enqueue(new Card(suits.charAt(i), "Q"));
        }

        for (int i=0; i < 52; i++){
            int randNum = ((int) (51 * Math.random()));
            Card tempCard = (Card) cards.dequeue();

            for (int j = 0; j < randNum; j++)
                cards.enqueue(cards.dequeue());

            cards.enqueue(tempCard);
        }
    }

    public Object takeCard(){
        if (cards.isEmpty()) {
            System.out.println("There is no card left!");
            return null;
        }
        else
            return cards.dequeue();
    }

    public boolean isDeckEmpty(){
        return cards.isEmpty();
    }
}