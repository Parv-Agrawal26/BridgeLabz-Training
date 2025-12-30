public class SnakeAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Problem");

        // Use Case 1
        int position = 0;
        System.out.println("Initial Position: " + position);

        // Use Case 2
        int dieRoll = (int) (Math.random() * 6) + 1;
        System.out.println("Die Roll: " + dieRoll);

        // Use Case 3
        int option = (int) (Math.random() * 3);
        switch (option) {
            case 0:
                System.out.println("No Play. Position remains the same: " + position);
                break;
            case 1:
                position += dieRoll;
                System.out.println("Ladder! Moved ahead to position: " + position);
                break;
            case 2:
                position -= dieRoll;
                if (position < 0)
                    position = 0;
                System.out.println("Snake! Moved back to position: " + position);
                break;
        }

        // Use Case 4
        while (position < 100) {
            dieRoll = (int) (Math.random() * 6) + 1;
            option = (int) (Math.random() * 3);
            switch (option) {
                case 0:
                    System.out.println("No Play. Position is same: " + position);
                    break;
                case 1:
                    position += dieRoll;
                    System.out.println("Ladder! Moved to position: " + position);
                    break;
                case 2:
                    position -= dieRoll;
                    if (position < 0)
                        position = 0;
                    System.out.println("Snake! Moved to position: " + position);
                    break;
            }
        }

        // Use Case 5
        position = 0;
        while (position < 100) {
            dieRoll = (int) (Math.random() * 6) + 1;
            option = (int) (Math.random() * 3);
            switch (option) {
                case 0:
                    System.out.println("No Play. Position is same: " + position);
                    break;
                case 1:
                    position += dieRoll;
                    if (position > 100) {
                        position -= dieRoll;
                    }
                    System.out.println("Ladder! Moved to position: " + position);
                    break;
                case 2:
                    position -= dieRoll;
                    if (position < 0)
                        position = 0;
                    System.out.println("Snake! Moved to position: " + position);
                    break;
            }
        }

        // Use Case 6
        int dieRollCount = 0;
        position = 0;
        while (position < 100) {
            dieRoll = (int) (Math.random() * 6) + 1;
            option = (int) (Math.random() * 3);
            switch (option) {
                case 0:
                    System.out.println("No Play. Position is same: " + position);
                    dieRollCount++;
                    break;
                case 1:
                    position += dieRoll;
                    if (position > 100) {
                        position -= dieRoll;
                    }
                    System.out.println("Ladder! Moved to position: " + position);
                    dieRollCount++;
                    break;
                case 2:
                    position -= dieRoll;
                    if (position < 0)
                        position = 0;
                    System.out.println("Snake! Moved to position: " + position);
                    dieRollCount++;
                    break;
            }
        }
        System.out.println("Total die rolls: " + dieRollCount);

        // Use Case 7
        int[] positions = new int[2];
        int currentPlayer = 0;
        while (positions[0] < 100 && positions[1] < 100) {
            dieRoll = (int) (Math.random() * 6) + 1;
            option = (int) (Math.random() * 3);
            System.out.println("Die rolled by player " + (currentPlayer + 1) + ": " + dieRoll);
            switch (option) {
                case 0:
                    System.out.println("No Play! Position is same " + positions[currentPlayer]);
                    break;
                case 1:
                    positions[currentPlayer] += dieRoll;
                    if (positions[currentPlayer] > 100) {
                        positions[currentPlayer] -= dieRoll;
                    }
                    System.out.println("Ladder! Moved to position: " + positions[currentPlayer]);
                    break;
                case 2:
                    positions[currentPlayer] -= dieRoll;
                    if (positions[currentPlayer] < 0) {
                        positions[currentPlayer] = 0;
                    }
                    System.out.println("Snake! Moved to position: " + positions[currentPlayer]);
                    break;
            }
            if (positions[currentPlayer] == 100) {
                System.out.println("Player " + (currentPlayer + 1) + " wins!");
                break;
            }
            if (option != 1) {
                currentPlayer = (currentPlayer + 1) % 2;
            }
        }
    }
}