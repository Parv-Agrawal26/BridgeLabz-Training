import java.util.*;

public class StockSpanProblem {

    static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < n; index++) {

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[index]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                span[index] = index + 1;
            } else {
                span[index] = index - stack.peek();
            }

            stack.push(index);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };

        int[] result = calculateSpan(prices);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
