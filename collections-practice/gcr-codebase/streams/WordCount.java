import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        HashMap<String, Integer> map = new HashMap<>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.toLowerCase().split("\\s+");
            for (String w : words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }

        br.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < 5 && i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }
    }
}
