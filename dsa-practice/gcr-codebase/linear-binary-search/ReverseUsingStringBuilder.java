import java.util.Scanner;

public class ReverseUsingStringBuilder {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String text = scn.nextLine();

        StringBuilder builder = new StringBuilder();
        builder.append(text);
        builder.reverse();

        System.out.println(builder.toString());
    }
}
