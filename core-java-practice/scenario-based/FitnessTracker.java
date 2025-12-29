import java.util.Scanner;
class FitnessTracker{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int[] pushUps=new int[7];
        for(int i=0;i<7;i++){
            System.out.println("Enter push ups for today: ");
            pushUps[day]=scn.nextInt();
        }
        int total=0;
        int count=0;
        for(int value:pushUps){
            if(value==0){
                continue;
            }
            total=total+value;
            count++;
        }
        double average=total/(double)count;
        System.out.println("Total push ups "+total);
        System.out.println("Average push ups "+average);
    }
}
