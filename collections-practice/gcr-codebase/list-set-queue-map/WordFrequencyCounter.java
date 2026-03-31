import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        text = text.toLowerCase().replaceAll("[^a-z ]", "");

        Map<String, Integer> map = new HashMap<>();
        for (String w : text.split(" ")) {
            if (w.isEmpty()) {
                continue;
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        System.out.println(map);
    }
}
