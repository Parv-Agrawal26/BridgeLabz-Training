import java.util.Scanner;
class UniqueChar{
    static char[] uniqueChars(String text) {
        char[] temp = new char[text.length()];
        int idx = 0;
        for (int i = 0; i < text.length(); i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == text.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[idx] = text.charAt(i);
                idx++;
            }
        }
        char[] res = new char[idx];
        for (int k = 0; k < idx; k++)
            res[k] = temp[k];
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++)
            freq[text.charAt(i)]++;
        char[] uniq = uniqueChars(text);
        for (int i = 0; i < uniq.length; i++) {
            System.out.println(uniq[i] + " " + freq[uniq[i]]);
        }
    }
}
