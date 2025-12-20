import java.util.Scanner;
class MeanOfHeight{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double[] heights = new double[11];
        double total = 0.0;
        for(int i=0; i<11; i++){
            heights[i] = scn.nextDouble();
            total+= heights[i];
        }
        double meanOfHeight =total/11.0;
        System.out.println("Mean height is " + meanOfHeight);
    }
}