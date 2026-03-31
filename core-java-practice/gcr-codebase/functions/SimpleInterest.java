import java.util.Scanner;
class SimpleInterest{
    static double calculateInterest(double principal,double rate,double time){
        double simpleInterest=principal*rate*time/100;
        return simpleInterest;
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        double principal=scn.nextDouble();
        double rate=scn.nextDouble();
        double time=scn.nextDouble();
        double result=calculateInterest(principal,rate,time);
        System.out.println("The Simple Interest is "+result+" for Principal "+principal+", Rate of Interest "+rate+" and Time "+time);
    }
}       