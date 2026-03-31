import java.util.Scanner;
class StudentScoreCard {
    static int[][] generateMarks(int students) {
        int[][] scores = new int[students][3];
        for (int row = 0; row < students; row++) {
            scores[row][0] = (int)(Math.random() * 100);
            scores[row][1] = (int) (Math.random() * 100);
            scores[row][2] = (int)(Math.random() * 100);
        }
        return scores;
    }
    static double[][] calculateValues(int[][] scores) {
        double[][] values = new double[scores.length][3];
        for (int row =0; row<scores.length;row++) {
            int total =scores[row][0]+ scores[row][1]+ scores[row][2];
            double average = total / 3.0;
            double percent = Math.round((average) *100.0)/100.0;
            values[row][0] =total;
            values[row][1] =average;
            values[row][2] =percent;
        }
        return values;
    }
    static String[] calculateGrade(double[][] values) {
        String[] grade = new String[values.length];
        for (int row = 0; row < values.length; row++) {
            if (values[row][2] >= 80)
                grade[row] = "A";
            else if (values[row][2]>= 70)
                grade[row] = "B";
            else if (values[row][2]>= 60)
                grade[row] = "C";
            else if (values[row][2]>= 50)
                grade[row] = "D";
            else if (values[row][2] >=40)
                grade[row] = "E";
            else
                grade[row] = "R";
        }
        return grade;
    }
    static void display(int[][] scores, double[][] values, String[] grade) {
        for (int row = 0; row < scores.length; row++) {
            System.out.println(scores[row][0] + " " +scores[row][1] + " " +scores[row][2] + " " +values[row][0] + " " +values[row][1] + " " +
                            values[row][2]+ " "+grade[row]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int students = scn.nextInt();
        int[][] scores = generateMarks(students);
        double[][] values = calculateValues(scores);
        String[] grade = calculateGrade(values);
        display(scores, values, grade);
    }
}
