public class StudentRegistrationSystem {
    public static void main(String[] args) {
        Student student = new Student("Alice", 20, "Female", "S12345");
        student.displayInfo();
        try {
            student.enrollCourse("Mathematics");
            student.enrollCourse("Physics");
            student.enrollCourse("Chemistry");
            student.enrollCourse("Biology");
            student.enrollCourse("English");
            student.enrollCourse("History");
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }
        RegistrationServiceSystem regService = new RegistrationServiceSystem();
        regService.setRegistrationStatus(student);
        student.assignGrade("A");
        student.displayInfo();
    }
}
