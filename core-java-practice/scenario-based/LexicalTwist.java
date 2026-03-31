import java.util.Scanner;

public class LexicalTwist {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the first word");
        String firstWord = scn.nextLine();
        if (firstWord.contains(" ")) {
            System.out.println(firstWord + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String secondWord = scn.nextLine();

        if (secondWord.contains(" ")) {
            System.out.println(secondWord + " is an invalid word");
            return;
        }

        String reversedFirst = "";

        for (int index = firstWord.length() - 1; index >= 0; index--) {
            reversedFirst = reversedFirst + firstWord.charAt(index);
        }

        if (reversedFirst.equalsIgnoreCase(secondWord)) {

            String transformed = reversedFirst.toLowerCase();
            String finalResult = "";

            for (int index = 0; index < transformed.length(); index++) {
                char currentChar = transformed.charAt(index);

                if (currentChar == 'a' || currentChar == 'e' ||
                        currentChar == 'i' || currentChar == 'o' ||
                        currentChar == 'u') {

                    finalResult = finalResult + "@";
                } else {
                    finalResult = finalResult + currentChar;
                }
            }

            System.out.println(finalResult);

        } else {
            String combined = (firstWord + secondWord).toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            for (int index = 0; index < combined.length(); index++) {
                char currentChar = combined.charAt(index);

                if (currentChar == 'A' || currentChar == 'E' ||
                        currentChar == 'I' || currentChar == 'O' ||
                        currentChar == 'U') {

                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }

            if (vowelCount > consonantCount) {

                String result = "";
                for (int index = 0; index < combined.length(); index++) {
                    char ch = combined.charAt(index);
                    if ("AEIOU".indexOf(ch) != -1 && result.indexOf(ch) == -1) {
                        result = result + ch;
                    }

                    if (result.length() == 2) {
                        break;
                    }
                }
                System.out.println(result);
            } else if (consonantCount > vowelCount) {
                String result = "";
                for (int index = 0; index < combined.length(); index++) {
                    char ch = combined.charAt(index);
                    if ("AEIOU".indexOf(ch) == -1 && result.indexOf(ch) == -1) {
                        result = result + ch;
                    }
                    if (result.length() == 2) {
                        break;
                    }
                }
                System.out.println(result);
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }
}
