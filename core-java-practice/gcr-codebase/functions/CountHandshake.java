import java.util.Scanner;
class CountHandshake {
    static int findHandshake(int students) {
        int totalHandshake = (students * (students - 1)) / 2;
        return totalHandshake;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int students = scn.nextInt();
        if (students < 0) {
            System.out.println("Invalid input");
            return;
        }
        int result = findHandshake(students);
        System.out.println("Maximum handshakes possible " + result);
    }
}
