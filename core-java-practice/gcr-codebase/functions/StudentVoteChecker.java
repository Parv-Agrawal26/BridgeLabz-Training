import java.util.Scanner;

public class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        if (age < 0)
            return false;
        if (age >= 18)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StudentVoteChecker obj = new StudentVoteChecker();
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            ages[i] = scn.nextInt();
            boolean result = obj.canStudentVote(ages[i]);
            System.out.println("Age " + ages[i] + " CanVote " + result);
        }
    }
}
