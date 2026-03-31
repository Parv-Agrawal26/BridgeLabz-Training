import java.util.ArrayList;
import java.util.Scanner;

class Exam {
    private ArrayList<Question> questions = new ArrayList<>();
    private EvaluationStrategy evaluationStrategy;
    private long timeLimitMillis;

    Exam(EvaluationStrategy strategy, long timeLimitMillis) {
        this.evaluationStrategy = strategy;
        this.timeLimitMillis = timeLimitMillis;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }

    ArrayList<Question> getQuestions() {
        return questions;
    }

    void start(Student student, Scanner scanner) throws ExamTimeExpiredException {

        long startTime = System.currentTimeMillis();

        for (Question q : questions) {

            if (System.currentTimeMillis() - startTime > timeLimitMillis) {
                throw new ExamTimeExpiredException("Time limit exceeded!");
            }

            q.display();
            System.out.print("Select answer: ");
            q.setUserAnswer(scanner.nextInt() - 1);
            System.out.println();
        }

        int score = evaluationStrategy.evaluate(this);
        student.setExamScore(score);

        System.out.println(
                "Exam completed! " + student.getName() +
                        ", Score: " + score + "/" + questions.size());
    }
}
