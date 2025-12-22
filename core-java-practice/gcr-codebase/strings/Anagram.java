import java.util.Scanner;
class Anagram{
    static boolean isAnagram(String first, String second) {
        if (first.length() != second.length())
            return false;
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        for (int i = 0; i < first.length(); i++) {
            freq1[first.charAt(i)]++;
            freq2[second.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String first = scn.next();
        String second = scn.next();
        System.out.println("Anagram " + isAnagram(first, second));
    }
}
