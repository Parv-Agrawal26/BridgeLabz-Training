import java.util.*;

public class SlidingWindowMaximum {

    static void printMaxInWindows(int[] arr, int windowSize) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int index = 0; index < arr.length; index++) {

            if (!deque.isEmpty() && deque.peekFirst() <= index - windowSize) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[index]) {
                deque.pollLast();
            }

            deque.addLast(index);

            if (index >= windowSize - 1) {
                System.out.print(arr[deque.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        printMaxInWindows(arr, k);
    }
}
