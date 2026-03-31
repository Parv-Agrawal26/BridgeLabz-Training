import java.util.Arrays;

public class ChallengeSearch {

    static int firstMissingPositive(int[] arr) {

        boolean[] present = new boolean[arr.length + 1];

        for (int value : arr) {
            if (value > 0 && value <= arr.length) {
                present[value] = true;
            }
        }

        for (int i = 1; i < present.length; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return arr.length + 1;
    }

    static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {3,4,-1,1};
        System.out.println(firstMissingPositive(arr));

        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 4));
    }
}
