import java.util.Scanner;
class StudentResult {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double physics = scn.nextDouble();
        double chemistry = scn.nextDouble();
        double maths = scn.nextDouble();
        double sum = physics + chemistry + maths;
        double average = sum / 3;
        String grade;
        String remark;
        if (average >= 80) {
            grade = "A";
            remark = "Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            grade = "B";
            remark = "Level 3, at agency-normalized standards";
        } else if (average >= 60) {
            grade = "C";
            remark = "Level 2, below but approaching agency-normalized standards";
        } else if (average >= 50) {
            grade = "D";
            remark = "Level 1, well below agency-normalized standards";
        } else if (average >= 40) {
            grade = "E";
            remark = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remark = "Remedial standards";
        }
        System.out.println("Average Marks: " + average +" Grade: " + grade +" Remarks: " + remark);
    }
}
