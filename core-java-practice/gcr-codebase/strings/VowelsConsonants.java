import java.util.Scanner;
class VowelConsCount {
    static int charType(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return 1;
            else
                return 2;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < text.length(); i++) {
            int result = charType(text.charAt(i));
            if (result == 1)
                vowelCount++;
            if (result == 2)
                consonantCount++;
        }
        System.out.println("Vowels " + vowelCount);
        System.out.println("Consonants " + consonantCount);
    }
}