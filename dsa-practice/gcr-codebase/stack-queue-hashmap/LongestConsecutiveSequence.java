import java.util.*;

public class LongestConsecutiveSequence {

    static int findLongest(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for (int value : arr) {
            set.add(value);
        }

        for (int value : arr) {
            if (!set.contains(value - 1)) {
                int current = value;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };

        System.out.println(findLongest(arr));
    }
}
