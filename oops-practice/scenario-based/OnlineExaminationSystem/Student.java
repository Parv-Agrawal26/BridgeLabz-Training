public class Student {
    private String name;
    private int studentId;
    private int examScore;

    Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    void setExamScore(int score) {
        this.examScore = score;
    }

    String getName() {
        return name;
    }
}
