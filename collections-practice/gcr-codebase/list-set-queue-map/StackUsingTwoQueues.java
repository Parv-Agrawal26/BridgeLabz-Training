import java.util.*;

public class StackUsingTwoQueues {

    static class StackUsingQueue {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        int pop() {
            if (q1.isEmpty()) {
                throw new NoSuchElementException("stack is empty");
            }
            return q1.remove();
        }

        int peek() {
            if (q1.isEmpty()) {
                throw new NoSuchElementException("stack is empty");
            }
            return q1.element();
        }

        boolean isEmpty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
