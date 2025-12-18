import java.util.Scanner;

class HandshakeCalculation {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int numberOfStudents = scn.nextInt();

        int maximumHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is " + maximumHandshakes);
    }
}
