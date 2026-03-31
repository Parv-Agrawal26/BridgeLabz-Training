import java.util.*;

public class SymmetricDifference {

    static <T> Set<T> symmetricDifference(Set<T> s1, Set<T> s2) {
        Set<T> sym = new HashSet<>(s1);
        sym.addAll(s2);

        Set<T> temp = new HashSet<>(s1);
        temp.retainAll(s2);

        sym.removeAll(temp);
        return sym;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println(symmetricDifference(s1, s2));
    }
}
