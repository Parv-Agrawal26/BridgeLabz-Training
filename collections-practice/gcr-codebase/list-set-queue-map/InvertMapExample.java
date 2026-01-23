import java.util.*;

public class InvertMapExample {

    static Map<Integer, List<String>> invert(Map<String, Integer> map) {
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (String key : map.keySet()) {
            inverted
                    .computeIfAbsent(map.get(key), k -> new ArrayList<>())
                    .add(key);
        }

        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 2);
        map.put("banana", 1);
        map.put("orange", 2);

        System.out.println(invert(map));
    }
}
