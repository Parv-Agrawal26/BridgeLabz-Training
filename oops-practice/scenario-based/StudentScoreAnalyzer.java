import java.util.*;

class InvalidScoreException extends Exception {
    InvalidScoreException(String message) {
        super(message);
    }
}

public class StudentScoreAnalyzer {

    static double calculateAverage(int[] scores) {
        int total = 0;
        for (int value : scores) {
            total += value;
        }
        return (double) total / scores.length;
    }

    static int findMax(int[] scores) {
        int max = scores[0];
        for (int value : scores) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    static int findMin(int[] scores) {
        int min = scores[0];
        for (int value : scores) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    static void validateScores(int[] scores) throws InvalidScoreException {
        for (int value : scores) {
            if (value < 0 || value > 100) {
                throw new InvalidScoreException("Invalid score found: " + value);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();

        int[] scores = new int[count];

        try {
            for (int index = 0; index < count; index++) {
                System.out.print("Enter score: ");
                scores[index] = scanner.nextInt();
            }

            validateScores(scores);

            System.out.println("Average Score: " + calculateAverage(scores));
            System.out.println("Highest Score: " + findMax(scores));
            System.out.println("Lowest Score: " + findMin(scores));

        } catch (InvalidScoreException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
