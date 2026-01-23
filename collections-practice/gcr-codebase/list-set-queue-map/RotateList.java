import java.util.*;

public class RotateList {

    static List<Integer> rotate(List<Integer> list, int k) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        k = k % list.size();
        if (k < 0) {
            k += list.size();
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(list.subList(k, list.size()));
        result.addAll(list.subList(0, k));

        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println(rotate(nums, 2));
    }
}
