import java.util.Scanner;
public class BusRouteDistanceTracker{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int totalDistance = 0;
        int stop=0;
        while(true){
            stop++;
            System.out.println("Enter continue to go on or exit to stop:");
            String input = scn.nextLine();
            if(input.equals("exit")){
                System.out.println("Total distance traveled: " + totalDistance);
                break;
            }
            else{
                totalDistance += 5;
                System.out.println("Distance after stop " + stop + ": " + totalDistance + " km");
            }
        }
    }
}