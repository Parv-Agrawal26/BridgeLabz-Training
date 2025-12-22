import java.util.Scanner;
class CalendarPrint {
    static boolean leapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }

    static int firstDay(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + (31 * m0) / 12) % 7;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int month = scn.nextInt();
        int year = scn.nextInt();
        int[] days = { 31,28, 31, 30, 31, 30,31, 31,30, 31, 30,31 };
        if (month == 2 && leapYear(year))
            days[1] = 29;
        int start = firstDay(month, year);
        for (int i = 0; i < start; i++)
            System.out.print("   ");
        for (int day = 1; day <= days[month - 1]; day++) {
            System.out.printf("%3d", day);
            if ((day + start) % 7 == 0)
                System.out.println();
        }
    }
}
