import java.util.Scanner;
class StringLength{
    static int getLen(String s) {
        int count = 0;
        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String txt = scn.next();
        int userLen = getLen(txt);
        int builtLen = txt.length();
        System.out.println("User length " + userLen);
        System.out.println("Built length " + builtLen);
    }
}
