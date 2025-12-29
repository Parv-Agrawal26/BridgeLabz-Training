import java.util.Scanner;
class LibraryFineCalculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int totalFine = 0;
        for (int book = 1; book <= 5; book++) {
            System.out.println("Enter due day" + book);
            int dueDate = scn.nextInt();
            System.out.println("Enter return day" + book);
            int returnDate = scn.nextInt();
            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * 5;
                totalFine = totalFine + fine;
                System.out.println("Fine" + fine);
            } else {
                System.out.println("No fine");
            }
        }
        System.out.println("Total fine " + totalFine);
    }
}
