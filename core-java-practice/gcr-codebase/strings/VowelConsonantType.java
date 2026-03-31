import java.util.Scanner;
class VowelConsonantType {
    static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }
    static String[][] findType(String text) {
        String[][] result = new String[text.length()][2];
        for (int index = 0; index < text.length(); index++) {
            result[index][0] = String.valueOf(text.charAt(index));
            result[index][1] = checkChar(text.charAt(index));
        }
        return result;
    }
    static void display(String[][] data) {
        for (int row = 0; row < data.length; row++) {
            System.out.println(data[row][0] + "   " + data[row][1]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        String[][] output = findType(text);
        display(output);
    }
}
