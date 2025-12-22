import java.util.Scanner;
class SubStringCheck {
    static String makeSub(String text, int start, int end) {
        String result = "";
        for (int i = start;i<end; i++) {
            result = result+ text.charAt(i);
        }
        return result;
    }
    static boolean compare(String a, String b) {
        if (a.length()!= b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.next();
        int start = scn.nextInt();
        int end = scn.nextInt();
        String userSub = makeSub(text, start, end);
        String builtSub = text.substring(start, end);
        boolean same = compare(userSub, builtSub);
        System.out.println("charAt substring " + userSub);
        System.out.println("builtin substring " + builtSub);
        System.out.println("Result same " + same);
    }
}
