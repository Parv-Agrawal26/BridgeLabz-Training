import java.util.Scanner;
class SumUntilZero{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        double total = 0.0;
        double value = scn.nextDouble();
        while (value!=0){
            total = total + value;
            value = scn.nextDouble();
        }
        System.out.println("The total value is " + total);
    }
}
