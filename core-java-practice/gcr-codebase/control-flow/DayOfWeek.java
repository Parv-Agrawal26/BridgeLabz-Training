import java.util.Scanner;
class DayOfWeek {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int month = scn.nextInt();
        int day = scn.nextInt();
        int year = scn.nextInt();
        int yo = year - (14 - month) / 12;
        int temp = yo + yo / 4 - yo / 100 + yo / 400;
        int mo = month + 12 * ((14 - month) / 12) - 2;
        int result = (day + temp + (31 * mo) / 12) % 7;
        System.out.println(result);
    }
}
