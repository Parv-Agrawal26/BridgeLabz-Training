import java.util.Scanner;
public class LineComparisionProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //starting message
        System.out.println("Welcome to Line Comparison Computation Program");

        //Use Case 1
        System.out.println("Enter coordinates for Line 1 (x1, y1, x2, y2): ");
        int x1 = scn.nextInt();
        int y1 = scn.nextInt();
        int x2 = scn.nextInt();
        int y2 = scn.nextInt();
        Double line1Length = findLength(x1, y1, x2, y2);
        System.out.println("Length of Line 1: " + line1Length);

        //Use Case 2
        System.out.println("Enter coordinates for Line 2 (x3, y3, x4, y4): ");
        int x3 = scn.nextInt();
        int y3 = scn.nextInt();
        int x4 = scn.nextInt();
        int y4 = scn.nextInt();
        Double line2Length = findLength(x3, y3, x4, y4);
        System.out.println("Length of Line 2: " + line2Length);
        if(line1Length.equals(line2Length)){
            System.out.println("Both lines are equal");
        } else {
            System.out.println("Lines are not equal");
        }

        //Use Case 3
        if(line1Length > line2Length){
            System.out.println("Line 1 is greater");
        } else if(line1Length < line2Length){
            System.out.println("Line 2 is greater");
        } else {
            System.out.println("Both lines are equal");
        }
    }

    public static Double findLength(int x1, int y1, int x2, int y2){
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
}