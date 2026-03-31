import java.util.*;

class InvalidMarkException extends Exception {
    InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentReportGenerator {

    static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int value : marks) {
            sum += value;
        }
        return (double) sum / marks.length;
    }

    static String assignGrade(double average) {
        if (average >= 80) {
            return "A";
        } else if (average >= 60) {
            return "B";
        }
        return "C";
    }

    static void validateMarks(int[] marks) throws InvalidMarkException {
        for (int value : marks) {
            if (value < 0 || value > 100) {
                throw new InvalidMarkException("Invalid marks found");
            }
        }
    }

    static void displayReport(Student student) {
        double average = calculateAverage(student.marks);
        String grade = assignGrade(average);

        System.out.println("Student Name: " + student.name);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        try {
            int[] marks1 = { 78, 85, 69 };
            validateMarks(marks1);
            studentList.add(new Student("Anil", marks1));

            for (Student student : studentList) {
                displayReport(student);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
