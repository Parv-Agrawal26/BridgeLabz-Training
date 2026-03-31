public class FirstNegativeSearch {

    static int findFirstNegative(int[] arr) {

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] < 0) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, -2, 8};
        System.out.println(findFirstNegative(arr));
    }
}
