import java.util.*;

public class RemoveDuplicatesSB {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();

        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int index = 0; index < text.length(); index++) {
            char ch = text.charAt(index);

            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }

        System.out.println(result.toString());
    }
}
