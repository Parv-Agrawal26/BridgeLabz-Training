import java.util.Scanner;
public class YoungestAmongThree {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int amarAge = scn.nextInt();
        int akbarAge = scn.nextInt();
        int anthonyAge = scn.nextInt();
        
        int amarHeight = scn.nextInt();
        int akbarHeight = scn.nextInt();
        int anthonyHeight = scn.nextInt();

        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            System.out.println("The youngest age is: " + amarAge);
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            System.out.println("The youngest age is: " + akbarAge);
        } else {
            System.out.println("The youngest age is: " + anthonyAge);
        }

        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            System.out.println("The tallest height is: " + amarHeight);
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            System.out.println("The tallest height is: " + akbarHeight);
        } else {
            System.out.println("The tallest height is: " + anthonyHeight);
        }
    }
}
