public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("+90","531","5265425");
        Address address1 = new Address("Çukur Mah.","5","Menemen","İzmir","Türkiye");
        Date date1 = new Date(5,7,2000);
        User user1 = new User("İsa","Karahan","M", date1, phone1, address1);

        Phone phone2 = new Phone("+90","232","1234567");
        Address address2 = new Address("DEU Kız Öğrenci Yurdu","0","Buca","İzmir","Türkiye");
        Date date2 = new Date(27,4,1980);
        User user2 = new User("Deniz","Tarak","F", date2, phone2, address2);

        CardDeck deck = new CardDeck();
        Stack stack = new Stack(15), tempStack = new Stack(15);
        boolean turn = true;

        do {
            stack.push(deck.takeCard());

            System.out.print(user1.getName() + ": " + user1.getScore() + " | " + user2.getName() + ": " + user2.getScore() + "  ||  ");
            if (turn) System.out.print(user1.getName() + "'s turn: ");
            else System.out.print(user2.getName() + "'s turn: ");

            while (!stack.isEmpty()){
                Card temp = (Card) stack.peek();
                System.out.print(temp.getSuit() + temp.getCardName() + " ");
                tempStack.push(stack.pop());
            }
            System.out.println();

            while (!tempStack.isEmpty())
                stack.push(tempStack.pop());

            if (stack.size() > 1){
                Card lastOne = (Card) stack.pop(), previousOne = (Card) stack.peek();

                if ((lastOne.getSuit() == previousOne.getSuit() || lastOne.getCardName().equals(previousOne.getCardName())) && !deck.isDeckEmpty()){
                    stack.push(lastOne);
                }
                else {
                    int tempScore = 0;

                    do {
                        if (lastOne.getSuit() == previousOne.getSuit()) tempScore++;
                        if (lastOne.getCardName().equals(previousOne.getCardName())) tempScore += 3;

                        if (stack.size() == 1) stack.pop();
                        else {
                            lastOne = (Card) stack.pop();
                            previousOne = (Card) stack.peek();
                        }
                    }
                    while (!stack.isEmpty());

                    if (turn) user1.increaseScore(tempScore);
                    else user2.increaseScore(tempScore);

                    turn = !turn;
                }
            }
        }
        while (user1.getScore() < 10 && user2.getScore() < 10 && !deck.isDeckEmpty());

        System.out.println();
        System.out.println(user1.getName() + " Score: " + user1.getScore());
        System.out.println(user2.getName() + " Score: " + user2.getScore() + "\n");

        if (user1.getScore() < user2.getScore()) System.out.print("Winner: " + user2.getName());
        else if (user1.getScore() > user2.getScore()) System.out.print("Winner: " + user1.getName());
        else System.out.print("Tie");
    }
}
