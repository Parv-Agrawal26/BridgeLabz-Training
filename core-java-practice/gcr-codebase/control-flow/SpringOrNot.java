import java.util.Scanner;
public class SpringOrNot{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int day = scn.nextInt();
        int month = scn.nextInt();
        if (month >= 3 && month <= 6 && ((month==3 && day >= 20) || (month==6 && day <= 20))) {
            System.out.println("It's Spring season.");
        } else {
            System.out.println("It's not Spring season.");
        }
    }
}