import java.util.Scanner;
class IndexOutOfBound {
    static void generate(String text) {
        System.out.println(text.charAt(text.length() + 1));
    }
    static void handle(String text) {
        try {
            System.out.println(text.charAt(text.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String index error handled");
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.next();
        handle(text);
    }
}
