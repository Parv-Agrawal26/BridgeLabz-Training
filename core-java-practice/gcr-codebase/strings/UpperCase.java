import java.util.Scanner;
class UpperCase{
    static String toUpper(String text) {
        String res = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            res = res + ch;
        }
        return res;
    }
    static boolean compare(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        String userUpper = toUpper(text);
        String builtUpper = text.toUpperCase();
        System.out.println("Result same " + compare(userUpper, builtUpper));
    }
}
