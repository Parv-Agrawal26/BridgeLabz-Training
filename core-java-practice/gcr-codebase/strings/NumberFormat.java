import java.util.Scanner;
class NumberFormat {
    static void generate(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }

    static void handle(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception handled");
        } catch (RuntimeException e) {
            System.out.println("Runtime exception handled");
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.next();
        handle(text);
    }
}
