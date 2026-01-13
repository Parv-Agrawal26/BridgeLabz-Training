public class DescriptiveEvaluationStrategy implements EvaluationStrategy {

    @Override
    public int evaluate(Exam exam) {
        return exam.getQuestions().size() / 2;
    }
}
