import java.util.Scanner;

class EduQuiz{
    static int calculateScore(String[] correctAnswers, String[] studentAnswers) {
        int score = 0;
        for (int index = 0; index < correctAnswers.length; index++) {
            if (studentAnswers[index].equalsIgnoreCase(correctAnswers[index])) {
                score++;
            }
        }
        return score;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] correctAnswers = { "A", "B", "C", "D", "A", "B", "C", "D", "A", "B" };
        String[] studentAnswers = new String[10];
        for (int question = 0; question < 10; question++) {
            System.out.println("Enter answer for Question " + (question + 1));
            studentAnswers[question] = scn.next();
        }
        int score = calculateScore(correctAnswers, studentAnswers);
        for (int index = 0; index < 10; index++) {
            if (studentAnswers[index].equalsIgnoreCase(correctAnswers[index])) {
                System.out.println("Question " + (index + 1) + ": Correct");
            } else {
                System.out.println("Question " + (index + 1) + ": Incorrect");
            }
        }

        double percentage = (score * 100.0) / 10;

        System.out.println("Total Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 40) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }
}
