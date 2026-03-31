public class Question {
    private String questionText;
    private String[] options;
    private int correctOptionIndex;
    private int userAnswer = -1;

    Question(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    void display() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    void setUserAnswer(int answer) {
        this.userAnswer = answer;
    }

    int getUserAnswer() {
        return userAnswer;
    }

    boolean isCorrect(int answer) {
        return answer == correctOptionIndex;
    }

    int getOptionCount() {
        return options.length;
    }
}
