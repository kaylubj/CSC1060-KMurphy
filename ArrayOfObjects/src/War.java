/**
 * Simulates a simple card game.
 */
public class War {

    public static void main(String[] args) {
        int loopCounter = 10000;
        int i = 0;

        // create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck.toString());

        // divide the deck into piles
        Pile p1 = new Pile();
        p1.addDeck(deck.subdeck(0, 25));
        System.out.println(p1.toString());
        Pile p2 = new Pile();
        p2.addDeck(deck.subdeck(26, 51));
        System.out.println(p2.toString());

        // while both piles are not empty
        while (!p1.isEmpty() && !p2.isEmpty() && i <= loopCounter) {
            i++;
            if (p2.isEmpty()) {
                System.out.println("Player 2 has no more cards for continued war!");
                System.out.println("Player 1 wins!");
                System.exit(0);
            }

            if (p1.isEmpty()) {
                System.out.println("Player 1 has no more cards for continued war!");
                System.out.println("Player 2 wins!");
                System.exit(0);
            }

            Card c1 = p1.popCard();
            System.out.println("Player 1 Card: " + c1.toString());
            Card c2 = p2.popCard();
            System.out.println("Player 2 Card: " + c2.toString());

            // compare the cards
            int diff = c1.getRank() - c2.getRank();

            if (diff > 0) {
                p1.addCard(c1);
                p1.addCard(c2);
                System.out.println("Player 1 wins that hand!");
            } else if (diff < 0) {
                p2.addCard(c1);
                p2.addCard(c2);
                System.out.println("Player 2 wins that hand!");
            } else {
                System.out.println("Tie! Let's draw 2 each");
                if (p1.isEmpty()) {
                    System.out.println("Player 1 doesn't have enough cards to break the tie!");
                    System.out.println("Player 2 Wins!");
                    System.exit(0);
                }
                if (p2.isEmpty()) {
                    System.out.println("Player 2 doesn't have enough cards to break the tie!");
                    System.out.println("Player 1 Wins!");
                    System.exit(0);
                }

                Card c1s = p1.popCard();
                Card c2s = p2.popCard();

                if (p1.isEmpty()) {
                    System.out.println("Player 1 doesn't have enough cards to break the tie!");
                    System.out.println("Player 2 Wins!");
                    System.exit(0);
                }
                if (p2.isEmpty()) {
                    System.out.println("Player 2 doesn't have enough cards to break the tie!");
                    System.out.println("Player 1 Wins!");
                    System.exit(0);
                }

                Card c3s = p1.popCard();
                Card c4s = p2.popCard();

                diff = c3s.getRank() - c4s.getRank();
                if (diff > 0) {
                    p1.addCard(c1);
                    p1.addCard(c2);
                    p1.addCard(c1s);
                    p1.addCard(c2s);
                    p1.addCard(c3s);
                    p1.addCard(c4s);
                    System.out.println("Player 1 Card: " + c3s.toString());
                    System.out.println("Player 2 Card: " + c4s.toString());
                    System.out.println("Player 1 wins the tie!");
                } else if (diff < 0) {
                    p2.addCard(c1);
                    p2.addCard(c2);
                    p2.addCard(c1s);
                    p2.addCard(c2s);
                    p2.addCard(c3s);
                    p2.addCard(c4s);
                    System.out.println("Player 1 Card: " + c3s.toString());
                    System.out.println("Player 2 Card: " + c4s.toString());
                    System.out.println("Player 2 wins the tie!");
                } else {
                    System.out.println("Player 1 Card: " + c3s.toString());
                    System.out.println("Player 2 Card: " + c4s.toString());

                    // Another tie - check if players have enough cards

                    System.out.println("Another tie! Need more cards...");
                    if (p1.isEmpty()) {
                        System.out.println("Player 1 has no more cards for continued war!");
                        System.out.println("Player 2 wins!");
                        System.exit(0);
                    } else if (p2.isEmpty()) {
                        System.out.println("Player 2 has no more cards for continued war!");
                        System.out.println("Player 1 wins!");
                        System.exit(0);
                    } else {
                        // If both have cards, just split the current war cards
                        p1.addCard(c1);
                        p1.addCard(c1s);
                        p1.addCard(c3s);
                        p2.addCard(c2);
                        p2.addCard(c2s);
                        p2.addCard(c4s);
                        System.out.println("Splitting the war cards and continuing...");
                    }

                    if (p2.isEmpty()) {
                        System.out.println("Player 2 has no more cards for continued war!");
                        System.out.println("Player 1 wins!");
                        System.exit(0);
                    }
                    if (p1.isEmpty()) {
                        System.out.println("Player 1 has no more cards for continued war!");
                        System.out.println("Player 2 wins!");
                        System.exit(0);
                    }
                }
            }
        }

        if (i == loopCounter + 1) {
            System.out.println("The game is in an infinite loop! Let's call it a draw!");
            System.exit(0);
            if (p2.isEmpty()) {
                System.out.println("Player 1 wins!");
                System.exit(0);
            } else {
                System.out.println("Player 2 wins!");
                System.exit(0);
            }

        }
        // display the winner
        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
            System.exit(0);
        } else {
            System.out.println("Player 2 wins!");
            System.exit(0);
        }

    }

}