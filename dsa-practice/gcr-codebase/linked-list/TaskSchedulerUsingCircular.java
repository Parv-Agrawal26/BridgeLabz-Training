

public class TaskSchedulerUsingCircular {
    public static void main(String[] args) {
        LinkedList taskList = new LinkedList();

        Task task1 = new Task("Design Module", 1, "High", "2024-06-15");
        Task task2 = new Task("Code Review", 2, "Medium", "2024-06-20");
        Task task3 = new Task("Testing", 3, "Low", "2024-06-25");

        taskList.addTaskFirst(task1);
        taskList.addTaskLast(task2);
        taskList.addTaskAtPos(task3, 1);

        System.out.println("Displaying all scheduled tasks:");
        taskList.displayTasks();

        System.out.println("\nSearching for tasks with priority 'Medium':");
        taskList.searchByPriority("Medium");

        System.out.println("\nDeleting task with ID 2:");
        taskList.deleteTaskById(2);

        System.out.println("\nDisplaying all scheduled tasks:");
        taskList.displayTasks();
    }
}
class Node {
    Task data;
    Node next;

    Node(Task data) {
        this.data = data;
        this.next = null;
    }
}

class Task {
    String name;
    int id;
    String priority;
    String dueDate;

    Task(String name, int id, String priority, String dueDate) {
        this.name = name;
        this.id = id;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class LinkedList {
    Node head;
    Node tail;

    void addTaskFirst(Task data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        System.out.println("Task added at first");
    }

    void addTaskLast(Task data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Task added at last");
    }

    void addTaskAtPos(Task data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            addTaskFirst(data);
            return;
        }
        Node current = head;
        int index = 1;
        while (index < pos && current.next != head) {
            current = current.next;
            index++;
        }
        newNode.next = current.next;
        current.next = newNode;
        if (current == tail) {
            tail = newNode;
        }
        System.out.println("Task added at position " + pos);
    }

    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        Node current = head;
        do {
            System.out.println("Task ID: " + current.data.id + ", Name: " + current.data.name + ", Priority: "
                    + current.data.priority + ", Due Date: " + current.data.dueDate);
            current = current.next;
        } while (current != head);
    }

    void deleteTaskById(int id) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }
        Node current = head;
        Node previous = tail;
        do {
            if (current.data.id == id) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                System.out.println("Task with ID " + id + " deleted.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task with ID " + id + " not found.");
    }

    void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        Node current = head;
        while (current != head) {
            if (current.data.priority.equals(priority)) {
                System.out.println("Task Found: ID: " + current.data.id + ", Name: " + current.data.name + ", Priority: "
                        + current.data.priority + ", Due Date: " + current.data.dueDate);
                return;
            }
            current = current.next;
        }
        System.out.println("No tasks with priority " + priority + " found.");
    }
}