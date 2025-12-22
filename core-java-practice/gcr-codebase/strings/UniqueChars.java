import java.util.Scanner;
class UniqueChars{
    static int getLen(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }
    static char[] unique(String text) {
        int length = getLen(text);
        char[] temp = new char[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[index] = current;
                index++;
            }
        }
        char[] result = new char[index];
        for (int k = 0; k < index; k++)
            result[k] = temp[k];
        return result;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        char[] res = unique(text);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
