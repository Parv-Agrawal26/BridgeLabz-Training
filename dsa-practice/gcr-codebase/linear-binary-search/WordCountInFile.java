import java.io.*;

public class WordCountInFile {

    public static void main(String[] args) throws Exception {

        String target = "java";
        int count = 0;

        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.equalsIgnoreCase(target)) {
                    count++;
                }
            }
        }

        System.out.println("Count: " + count);
        br.close();
    }
}
