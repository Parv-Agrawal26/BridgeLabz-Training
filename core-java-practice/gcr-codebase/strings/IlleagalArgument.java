import java.util.Scanner;
class IllegalArgument{
    static void generate(String text) {
        System.out.println(text.substring(5, 2));
    }
    static void handle(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument handled");
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
