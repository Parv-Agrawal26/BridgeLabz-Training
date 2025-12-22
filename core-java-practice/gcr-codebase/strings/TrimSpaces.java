import java.util.Scanner;
class TrimSpaces{
    static int[] findRange(String text) {
        int start = 0, end = text.length() - 1;
        while (start < text.length() && text.charAt(start) == ' ')
            start++;
        while (end >= 0 && text.charAt(end) == ' ')
            end--;
        return new int[] { start, end + 1 };
    }
    static String makeSub(String text, int start, int end) {
        String result = "";
        for (int pos = start; pos < end; pos++) {
            result = result + text.charAt(pos);
        }
        return result;
    }
    static boolean compare(String first, String second) {
        if (first.length() != second.length())
            return false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        int[] range = findRange(text);
        String userTrim = makeSub(text, range[0], range[1]);
        String builtTrim = text.trim();
        System.out.println("Same result " + compare(userTrim, builtTrim));
    }
}
