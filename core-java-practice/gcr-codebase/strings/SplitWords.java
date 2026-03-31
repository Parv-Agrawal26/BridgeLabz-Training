import java.util.Scanner;
class SplitWords{
    static int len(String s) {
        int c = 0;
        while (true) {
            try {
                s.charAt(c);
                c++;
            } catch (Exception e) {
                break;
            }
        }
        return c;
    }
    static String[] splitMan(String t) {
        int l = len(t);
        int wc = 1;
        for (int i= 0; i <l;i++) {
            if (t.charAt(i) == ' ')
                wc++;
        }
        String[] words = new String[wc];
        int idx = 0;
        String cur = "";
        for (int i = 0; i <l;i++) {
            if (t.charAt(i) == ' ') {
                words[idx] = cur;
                idx++;
                cur="";
            } else {
                cur = cur + t.charAt(i);
            }
        }
        words[idx] = cur;
        return words;
    }

    static boolean compare(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        String[] userArr = splitMan(text);
        String[] builtArr = text.split(" ");
        System.out.println("Same result " + compare(userArr, builtArr));
    }
}
