import java.util.Scanner;

public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.println("Enter your lucky number:");
            int luckyNumber = scn.nextInt();
            if (luckyNumber % 3 == 0 && luckyNumber % 5 == 0) {
                System.out.println("Congratulations! You have won!");
            } else {
                System.out.println("Sorry! Better luck next time.");
            }
            System.out.println("Do you want to try again? (yes/no)");
            String response = scn.next();
            if (response.equals("no")) {
                break;
            }
        }
    }
}