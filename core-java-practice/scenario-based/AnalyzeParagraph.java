/*2. Scenario: Create a program that analyzes a given paragraph of text. Implement the following
functionalities:
● Count the number of words in the paragraph.
● Find and display the longest word.
● Replace all occurrences of a specific word with another word (case-insensitive).
● Handle edge cases like empty strings or paragraphs with only spaces.*/

import java.util.Scanner;

public class AnalyzeParagraph {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = scn.nextLine().trim();

        if (paragraph.isEmpty()) {
            System.out.println("The paragraph is empty.");
            return;
        }

        String[] words = paragraph.split("\\s+");
        int wordCount = words.length;
        System.out.println("Number of words: " + wordCount);

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest word: " + longestWord);

        System.out.println("Enter the word to be replaced:");
        String targetWord = scn.nextLine();
        System.out.println("Enter the replacement word:");
        String replacementWord = scn.nextLine().trim();
        for (int i = 0; i < words.length; i++) {
            {
                if (words[i].equalsIgnoreCase(targetWord)) {
                    words[i] = replacementWord;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if (i < words.length - 1) {
                System.out.print(" ");
            }
        }
    }
}