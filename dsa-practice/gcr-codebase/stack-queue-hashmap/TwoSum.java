import java.util.*;

public class TwoSum {

    static int[] findTwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < arr.length; index++) {
            int remaining = target - arr[index];

            if (map.containsKey(remaining)) {
                return new int[] { map.get(remaining), index };
            }
            map.put(arr[index], index);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = findTwoSum(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
