import java.util.Scanner;
class NestedFreq {
    static String[] frequency(String text) {
        char[] chars = text.toCharArray();
        int[] count = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            count[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count[i]++;
                    chars[j] = '0';
                }
            }
        }
        String[] result = new String[chars.length];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " " + count[i];
                index++;
            }
        }
        String[] finalRes = new String[index];
        for (int k = 0; k < index; k++)
            finalRes[k] = result[k];
        return finalRes;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        String[] res = frequency(text);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
