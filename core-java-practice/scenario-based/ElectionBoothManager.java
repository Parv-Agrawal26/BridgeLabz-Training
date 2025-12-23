import java.util.Scanner;
class ElectionBoothManager{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int candidate1Votes=0;
        int candidate2Votes=0;
        int candidate3Votes=0;
        while(true){
            int age=scn.nextInt();
            if(age==-1){
                break;
            }
            if(age<18){
                System.out.println("Not eligible to vote");
                continue;
            }
            int vote=scn.nextInt();
            if(vote==1){
                candidate1Votes++;
            }else if(vote==2){
                candidate2Votes++;
            }else if(vote==3){
                candidate3Votes++;
            }else{
                System.out.println("Invalid vote");
            }
        }
        System.out.println("Candidate 1 votes "+candidate1Votes);
        System.out.println("Candidate 2 votes "+candidate2Votes);
        System.out.println("Candidate 3 votes "+candidate3Votes);
    }
}
