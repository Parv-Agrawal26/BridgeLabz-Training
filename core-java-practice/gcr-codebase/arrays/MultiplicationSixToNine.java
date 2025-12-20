import java.util.Scanner;
class MultiplicationSixToNine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num=scn.nextInt();
        int[] resultArray = new int[4];
        int index =0;
        for (int i = 6; i <= 9; i++) {
            resultArray[index] = num * i;
            index++;
        }
        index=0;
        for (int i = 6;i <= 9;i++) {
            System.out.println(num +" * " + i + " = " +resultArray[index]);
            index++;
        }
    }
}
