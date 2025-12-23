import java.util.Scanner;
class MetroCard{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        double balance=scn.nextDouble();
        while (true) {
            if (balance <= 0) {
                System.out.println("Balance exhausted");
                break;
            }
            double distance =scn.nextDouble();
            if (distance==-1) {
                break;
            }
            double fare =(distance <= 5) ?20 :(distance <= 10) ? 30 : 40;
            if (fare>balance) {
                System.out.println("Not enough balance");
                break;
            }
            balance = balance - fare;
            System.out.println("Fare deducted "+fare);
            System.out.println("Remaining balance "+balance);
        }
    }
}
