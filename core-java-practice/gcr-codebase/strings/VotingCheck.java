import java.util.Scanner;

class VotingCheck {
    static int[] generateAges(int total) {
        int[] ages = new int[total];
        for (int index = 0; index < total; index++) {
            ages[index] = (int) (Math.random() * 90);
        }
        return ages;
    }
    static String[][] checkVote(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int index = 0; index < ages.length; index++) {
            result[index][0] = String.valueOf(ages[index]);
            if (ages[index] >= 18)
                result[index][1] = "true";
            else
                result[index][1] = "false";
        }
        return result;
    }
    static void display(String[][] data) {
        for (int row = 0; row < data.length; row++) {
            System.out.println("Age " + data[row][0] + " CanVote " + data[row][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();
        int[] ages = generateAges(count);
        String[][] output = checkVote(ages);
        display(output);
    }
}
