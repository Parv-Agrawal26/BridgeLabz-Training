public class Student {
    String name;
    int rollNumber;
    int mark1;
    int mark2;
    int mark3;

    Student(String name, int rollNumber, int mark1, int mark2, int mark3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public String getGrade() {
        double average = (mark1 + mark2 + mark3) / 3.0;
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void printDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade: " + getGrade());
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice", 1, 85, 90, 78);
        Student student2 = new Student("Bob", 2, 65, 70, 72);
        student1.printDetails();
        System.out.println();
        student2.printDetails();
    }

}
