import java.util.Scanner;

class PalindromeCheck {
    static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.next();
        System.out.println(isPalindrome(text));
        scn.close();
    }
}
