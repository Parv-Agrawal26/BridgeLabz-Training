import java.io.*;
import java.util.*;

public class UserInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            FileWriter fw = new FileWriter("user.txt");

            System.out.print("Enter name: ");
            fw.write("Name: " + sc.nextLine() + "\n");

            System.out.print("Enter age: ");
            fw.write("Age: " + sc.nextLine() + "\n");

            System.out.print("Favorite language: ");
            fw.write("Language: " + sc.nextLine());

            fw.close();
            System.out.println("Data saved");

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
