import java.util.Scanner;

class CollinearPoints {
    static boolean usingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    static boolean usingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x1 = scn.nextInt();
        int y1 = scn.nextInt();
        int x2 = scn.nextInt();
        int y2 = scn.nextInt();
        int x3 = scn.nextInt();
        int y3 = scn.nextInt();
        if (usingSlope(x1, y1, x2, y2, x3, y3) && usingArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are Collinear");
        } else {
            System.out.println("Points are not Collinear");
        }
    }
}
