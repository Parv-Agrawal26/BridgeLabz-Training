import java.util.*;

public class NthFromEnd {

    static String findNth(LinkedList<String> list, int n) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("n must be >= 1");
        }

        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("n is larger than list size");
            }
            fast.next();
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(findNth(list, 2));
    }
}
