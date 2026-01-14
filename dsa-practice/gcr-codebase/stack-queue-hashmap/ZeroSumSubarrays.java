import java.util.*;

public class ZeroSumSubarrays {

    static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        for (int index = 0; index < arr.length; index++) {
            sum += arr[index];

            if (sum == 0) {
                System.out.println("Subarray found from 0 to " + index);
            }

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray found from " + (start + 1) + " to " + index);
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(index);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, -7, 3, 1, 3, -4 };

        findZeroSumSubarrays(arr);
    }
}
