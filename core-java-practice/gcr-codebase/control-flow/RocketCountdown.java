import java.util.Scanner;
class RocketCountdown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int counter = scn.nextInt();
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
    }
}
