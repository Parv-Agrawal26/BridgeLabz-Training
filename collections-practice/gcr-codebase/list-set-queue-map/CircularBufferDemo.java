import java.util.*;

public class CircularBufferDemo {

    static class CircularBuffer {
        private final int[] buffer;
        private int index = 0;

        CircularBuffer(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("capacity must be > 0");
            }
            this.buffer = new int[capacity];
        }

        void insert(int value) {
            buffer[index % buffer.length] = value;
            index++;
        }

        List<Integer> snapshot() {
            List<Integer> result = new ArrayList<>(buffer.length);
            for (int v : buffer) {
                result.add(v);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(10);
        cb.insert(20);
        cb.insert(30);
        System.out.println(cb.snapshot());

        cb.insert(40);
        System.out.println(cb.snapshot());
    }
}
