import java.util.Scanner;
class ChocolateDivision {
    static int[] findRemainderAndQuotient(int chocolate, int children) {
        int each = chocolate /children;
        int remain = chocolate% children;
        return new int[] { each, remain };
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int chocolate = scn.nextInt();
        int children = scn.nextInt();
        int[] result = findRemainderAndQuotient(chocolate, children);
        System.out.println("Each child get " + result[0]);
        System.out.println("Remaining chocolate " + result[1]);
    }
}
