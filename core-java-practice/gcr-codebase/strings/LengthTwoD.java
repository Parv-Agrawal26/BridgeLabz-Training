import java.util.Scanner;

class LengthTwoD {
    static int getLen(String s) {
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
        int wc = 1;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == ' ')
                wc++;
        }
        String[] w = new String[wc];
        int id = 0;
        String cur = "";
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == ' ') {
                w[id] = cur;
                id++;
                cur = "";
            } else
                cur += t.charAt(i);
        }
        w[id] = cur;
        return w;
    }

    static String[][] make2D(String[] w) {
        String[][] arr = new String[w.length][2];
        for (int i = 0; i < w.length; i++) {
            arr[i][0] = w[i];
            arr[i][1] = String.valueOf(getLen(w[i]));
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        String[] words = splitMan(text);
        String[][] res = make2D(words);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "   " + Integer.parseInt(res[i][1]));
        }
    }
}
