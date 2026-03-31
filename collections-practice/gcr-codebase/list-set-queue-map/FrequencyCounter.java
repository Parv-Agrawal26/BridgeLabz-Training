import java.util.*;

public class FrequencyCounter {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println(freqMap);
    }
}
