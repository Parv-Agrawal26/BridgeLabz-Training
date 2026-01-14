import java.util.*;

public class PairWithGivenSum {

    static boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int value : arr) {
            if (set.contains(target - value)) {
                return true;
            }
            set.add(value);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 4, 1, 6 };
        int target = 10;

        System.out.println(hasPair(arr, target));
    }
}
