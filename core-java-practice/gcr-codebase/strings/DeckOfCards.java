import java.util.Scanner;
class DeckOfCards {
    static String[] createDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        return deck;
    }
    static void shuffle(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int rand = i + (int) (Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }
    static String[][] distribute(String[] deck, int players, int cards) {
        String[][] result = new String[players][cards];
        int index = 0;
        for (int p = 0; p < players; p++) {
            for (int c = 0; c < cards; c++) {
                result[p][c] = deck[index];
                index++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int players = scn.nextInt();
        int cards = scn.nextInt();
        String[] deck = createDeck();
        shuffle(deck);
        if (players * cards > deck.length) {
            System.out.println("Not possible");
            return;
        }
        String[][] result = distribute(deck, players, cards);
        for (int i = 0; i < result.length; i++) {
            System.out.println("Player " + (i + 1));
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}
