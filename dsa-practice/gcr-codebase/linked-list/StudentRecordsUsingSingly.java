
public class StudentRecordsUsingSingly {
    public static void main(String[] args) {
        LinkedList studentList = new LinkedList();

        StudentRecord student1 = new StudentRecord("Alice", 20, 101, 'A');
        StudentRecord student2 = new StudentRecord("Bob", 21, 102, 'B');
        StudentRecord student3 = new StudentRecord("Charlie", 22, 103, 'C');

        studentList.addAtFirst(student1);
        studentList.addAtLast(student2);
        studentList.addAtPos(student3, 1);

        System.out.println("Displaying all student records:");
        studentList.displayRecords();

        System.out.println("\nSearching for roll no 102:");
        studentList.searchByRollNo(102);

        System.out.println("\nUpdating grade for roll no 101 to 'B':");
        studentList.updateGradeByRollNo(101, 'B');

        System.out.println("\nDisplaying all student records");
        studentList.displayRecords();

        System.out.println("\nDeleting record with roll no 102:");
        studentList.deleteByRollNo(102);

        System.out.println("\nDisplaying all student records");
        studentList.displayRecords();
    }
}

class Node {
    StudentRecord data;
    Node next;

    Node(StudentRecord data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void addAtFirst(StudentRecord data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Date record added at first");
    }

    void addAtLast(StudentRecord data) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(data);
        current.next = newNode;
        System.out.println("Date record added at last");
    }

    void addAtPos(StudentRecord data, int pos) {
        Node newNode = new Node(data);
        Node current = head;
        int inx = 1;
        while (inx < pos) {
            current = current.next;
            inx++;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
        System.out.println("Date record added at position " + pos);
    }

    void deleteByRollNo(int rollNo) {
        Node current = head;
        if (current != null && current.data.rollNo == rollNo) {
            head = current.next;
            System.out.println("Record with roll no " + rollNo + " deleted");
            return;
        }
        while (current.next != null) {
            if (current.next.data.rollNo == rollNo) {
                current.next = current.next.next;
                System.out.println("Record with roll no " + rollNo + " deleted");
                return;
            }
            current = current.next;
        }
    }

    void displayRecords() {
        Node current = head;
        while (current != null) {
            System.out.println("Name: " + current.data.name + ", Age: " + current.data.age + ", Roll No: "
                    + current.data.rollNo + ", Grade: " + current.data.grade);
            current = current.next;
        }
    }

    void searchByRollNo(int rollNo) {
        Node current = head;
        while (current != null) {
            if (current.data.rollNo == rollNo) {
                System.out.println("Record Found: Name: " + current.data.name + ", Age: " + current.data.age
                        + ", Roll No: " + current.data.rollNo + ", Grade: " + current.data.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Record with roll no " + rollNo + " not found");
    }

    void updateGradeByRollNo(int rollNo, char newGrade) {
        Node current = head;
        while (current != null) {
            if (current.data.rollNo == rollNo) {
                current.data.grade = newGrade;
                System.out.println("Record with roll no " + rollNo + " updated with new grade " + newGrade);
                return;
            }
            current = current.next;
        }
        System.out.println("Record with roll no " + rollNo + " not found");
    }
}

class StudentRecord {
    String name;
    int age;
    int rollNo;
    char grade;

    StudentRecord(String name, int age, int rollNo, char grade) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.grade = grade;
    }
}