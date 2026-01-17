public class SentenceSearch {

    static String search(String[] sentences, String word) {

        for (int index = 0; index < sentences.length; index++) {
            if (sentences[index].contains(word)) {
                return sentences[index];
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {

        String[] lines = {
            "Java is powerful",
            "Python is easy",
            "I like coding"
        };

        System.out.println(search(lines, "Java"));
    }
}
