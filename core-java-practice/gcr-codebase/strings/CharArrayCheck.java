import java.util.Scanner;
class CharArrayCheck {
    static char[] getChars(String text) {
        char[] arr = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }
    static boolean compare(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.next();
        char[] userArr = getChars(text);
        char[] builtArr = text.toCharArray();
        boolean result = compare(userArr, builtArr);
        System.out.println("Arrays same " + result);
    }
}
