import java.util.LinkedList;
import java.util.Queue;
class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        while (q1.size() != 0)
            q2.add(q1.remove());
        q1.add(x);
        while (q2.size() != 0)
            q1.add(q2.remove());
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.size() == 0;
    }
}

/**
 * Your StackUsingQueue object will be instantiated and called as such:
 * StackUsingQueue obj = new StackUsingQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */