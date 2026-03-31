public class RegistrationServiceSystem extends RegistrationService {
    void setRegistrationStatus(Student student) {
        student.registered = true;
        System.out.println("Student " + student.getName() + " is now registered.");
    }
}
