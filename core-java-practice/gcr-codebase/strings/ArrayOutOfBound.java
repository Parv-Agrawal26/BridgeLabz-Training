import java.util.Scanner;
class ArrayOutOfBound{
    static void generate(String[] names) {
        System.out.println(names[10]);
    }
    static void handle(String[] names) {
        try {
            System.out.println(names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index exception handled");
        } catch (RuntimeException e) {
            System.out.println("Runtime exception handled");
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] names = new String[3];
        for (int i = 0; i < 3; i++) {
            names[i] = scn.next();
        }
        handle(names);
    }
}
