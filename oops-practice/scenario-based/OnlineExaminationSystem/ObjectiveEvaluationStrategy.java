public class ObjectiveEvaluationStrategy implements EvaluationStrategy {

    @Override
    public int evaluate(Exam exam) {
        int score = 0;

        for (Question q : exam.getQuestions()) {
            if (q.isCorrect(q.getUserAnswer())) {
                score++;
            }
        }
        return score;
    }
}
