
import java.util.*;

class ExamProctor {

    Stack<Integer> navigation = new Stack<>();
    HashMap<Integer, String> answers = new HashMap<>();

    void visitQuestion(int questionId) {
        navigation.push(questionId);
    }

    void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    int evaluate() {

        int score = 0;
        for (String ans : answers.values()) {
            if (ans.equalsIgnoreCase("A")) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {

        ExamProctor exam = new ExamProctor();
        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");
        exam.submitAnswer(2, "B");
        System.out.println("Score: " + exam.evaluate());
    }
}
