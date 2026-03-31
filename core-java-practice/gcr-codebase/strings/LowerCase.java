import java.util.Scanner;
class LowerCase{
    static String toLower(String text) {
        String res="";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            res = res + ch;
        }
        return res;
    }
    static boolean compare(String a,String b) {
        if (a.length() !=b.length()) {
            return false;
        }
        for (int i=0; i<a.length();i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        String text = scn.nextLine();
        String userLower =toLower(text);
        String builtLower =text.toLowerCase();
        System.out.println("Result same " + compare(userLower, builtLower));
    }
}
