import java.util.*;

class InvalidQuizSubmissionException extends Exception {
    InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class OnlineQuizProcessor {

    static int calculateScore(String[] correct, String[] user) throws InvalidQuizSubmissionException {
        if (correct.length != user.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }

        int score = 0;
        for (int index = 0; index < correct.length; index++) {
            if (correct[index].equalsIgnoreCase(user[index])) {
                score++;
            }
        }
        return score;
    }

    static String getGrade(int score) {
        if (score >= 8) {
            return "A";
        } else if (score >= 5) {
            return "B";
        }
        return "C";
    }

    public static void main(String[] args) {
        List<Integer> scoreList = new ArrayList<>();

        String[] correctAnswers = { "A", "B", "C", "D", "A" };
        String[] userAnswers = { "A", "B", "D", "D", "A" };

        try {
            int score = calculateScore(correctAnswers, userAnswers);
            scoreList.add(score);

            System.out.println("Score: " + score);
            System.out.println("Grade: " + getGrade(score));

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
