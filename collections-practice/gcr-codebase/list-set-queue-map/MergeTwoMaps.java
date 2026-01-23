import java.util.*;

public class MergeTwoMaps {

    static Map<String, Integer> merge(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);

        for (String k : map2.keySet()) {
            result.put(k, result.getOrDefault(k, 0) + map2.get(k));
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 2);
        map1.put("banana", 1);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 3);
        map2.put("orange", 4);

        System.out.println(merge(map1, map2));
    }
}
