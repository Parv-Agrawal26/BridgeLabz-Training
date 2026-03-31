import java.util.ArrayList;

class Student extends Person {
    private String studentId;
    private ArrayList<String> courseEnrolled;
    protected boolean registered;
    private String grade;

    Student(String name, int age, String gender, String studentId) {
        super(name, age, gender);
        this.studentId = studentId;
        this.courseEnrolled = new ArrayList<>();
        this.registered = false;
        this.grade = "NA";
    }

    void displayInfo() {
        System.out.println("Name: " + super.getName());
        System.out.println("Age: " + super.getAge());
        System.out.println("Gender: " + super.getGender());
        System.out.println("Student ID: " + studentId);
        System.out.println("Registration Status: " + (registered ? "Registered" : "Not Registered"));
        if (courseEnrolled.size() == 0) {
            System.out.println("No courses enrolled");
        } else {
            for (String course : courseEnrolled) {
                System.out.println(course);
            }
        }
        System.out.println("Grade: " + grade);
    }

    void enrollCourse(String course) throws CourseLimitExceededException {
        if (courseEnrolled.size() >= 5) {
            throw new CourseLimitExceededException("Cannot enroll in more than 5 courses.");
        }
        this.courseEnrolled.add(course);
    }

    void dropCourse(String course) throws CourseLimitExceededException {
        if (courseEnrolled.size() > 0) {
            this.courseEnrolled.remove(course);
        }
    }

    void assignGrade(String grade) {
        this.grade = grade;
    }
}