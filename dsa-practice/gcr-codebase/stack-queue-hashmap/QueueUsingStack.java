import java.util.Stack;
public class QueueUsingStack {
    public static void main(String[] args) {
        Stack<Integer> enqueue = new Stack<>();
        Stack<Integer> dequeue = new Stack<>();
        addToQueue(enqueue, 10);
        addToQueue(enqueue, 20);
        addToQueue(enqueue, 30);
        addToQueue(enqueue, 40);

        displayQueue(enqueue);

        removeFromQueue(enqueue, dequeue);
        removeFromQueue(enqueue, dequeue);
        displayQueue(enqueue);
        
    }
    
    static void addToQueue(Stack<Integer> enqueue, int data) {
        enqueue.push(data);
        System.out.println("Data added to queue");
    }
    static void removeFromQueue(Stack<Integer> enqueue, Stack<Integer> dequeue){
        if(enqueue.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        while(enqueue.size()>1){
            dequeue.push(enqueue.pop());
        }
        System.out.println("Removed element: "+ enqueue.pop());
        while(!dequeue.isEmpty()){
            enqueue.push(dequeue.pop());
        }
    }
    static void displayQueue(Stack<Integer> enqueue){
        if(enqueue.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Elements in the queue are: ");
        for(int i=0;i<enqueue.size();i++){
            System.out.print(enqueue.get(i)+" ");
        }
        System.out.println();
    }
}
