import java.util.Scanner;
class StudentScoreManager {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of students");
        int numberOfStudents = scn.nextInt();
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students");
            return;
        }
        int[] scores = new int[numberOfStudents];
        int index = 0;
        while (index < numberOfStudents) {
            System.out.println("Enter score for student " + (index + 1));
            if (!scn.hasNextInt()) {
                System.out.println("Invalid input enter numeric value");
                scn.next();
                continue;
            }
            int score = scn.nextInt();
            if (score < 0) {
                System.out.println("Score cannot be negative");
                continue;
            }
            scores[index] = score;
            index++;
        }
        int total = 0;
        int highest = scores[0];
        int lowest = scores[0];
        for (int value : scores) {
            total = total + value;
            if (value > highest) {
                highest = value;
            }
            if (value < lowest) {
                lowest = value;
            }
        }
        double average = (double) total / numberOfStudents;
        System.out.println("Average Score " + average);
        System.out.println("Highest Score " + highest);
        System.out.println("Lowest Score " + lowest);
        System.out.println("Scores above average");
        for (int value : scores) {
            if (value > average) {
                System.out.println(value);
            }
        }
    }
}
