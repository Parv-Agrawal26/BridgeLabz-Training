import java.util.*;

public class GenerateBinaryNumbers {

    static List<String> generate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String curr = q.remove();
            result.add(curr);

            q.add(curr + "0");
            q.add(curr + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        for (String s : generate(n)) {
            System.out.println(s);
        }
    }
}
