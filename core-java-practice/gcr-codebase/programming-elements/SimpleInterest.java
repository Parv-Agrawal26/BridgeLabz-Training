public class SimpleInterest {
    public static void main(String[] args) {
        double principal = 1000.0;
        double rate = 5.0;
        double time = 3.0;
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("The simple interest for principal " + principal + ", rate " + rate + "%, and time " + time + " years is: " + simpleInterest);
    }
}