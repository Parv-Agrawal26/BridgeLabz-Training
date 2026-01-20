import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinStack {

    Stack<Integer> st;
    Queue<Integer> pq;
    int min;

    public MinStack() {
        st = new Stack<>();
        pq = new PriorityQueue<>();
    }

    public void push(int val) {
        st.push(val);
        pq.add(val);
    }

    public void pop() {
        int k = st.pop();
        pq.remove(k);
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return pq.peek();

    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
