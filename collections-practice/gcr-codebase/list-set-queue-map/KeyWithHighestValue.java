import java.util.*;

public class KeyWithHighestValue {

    static String maxKey(Map<String, Integer> map) {
        String maxKey = null;
        int max = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                maxKey = e.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 5);
        map.put("c", 20);

        System.out.println(maxKey(map));
    }
}
