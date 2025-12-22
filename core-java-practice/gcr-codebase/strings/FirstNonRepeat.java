import java.util.Scanner;
class FirstNonRepeat {
    static char findChar(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return ' ';
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        char result = findChar(text);
        System.out.println("First non repeat " + result);
    }
}
