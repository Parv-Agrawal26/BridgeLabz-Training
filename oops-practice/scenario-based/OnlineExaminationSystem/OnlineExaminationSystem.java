import java.util.Scanner;

public class OnlineExaminationSystem {
    public static void main(String[] args) {

        EvaluationStrategy strategy = new ObjectiveEvaluationStrategy();
        Exam exam = new Exam(strategy, 30000);

        exam.addQuestion(new Question("Capital of India?",new String[] { "Berlin", "Madrid", "Delhi", "Rome" },3));

        exam.addQuestion(new Question("2 + 2?",new String[] { "3", "4", "5", "6" },1));

        Student student = new Student("Alice", 101);
        Scanner scanner = new Scanner(System.in);

        try {
            exam.start(student, scanner);
        } catch (ExamTimeExpiredException e) {
            System.out.println("Exam failed: " + e.getMessage());
        }
    }
}
