import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    String roleName;

    JobRole(String roleName) {
        this.roleName = roleName;
    }

    abstract void processResume();
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }

    void processResume() {
        System.out.println("Processing resume for Software Engineer");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }

    void processResume() {
        System.out.println("Processing resume for Data Scientist");
    }
}

class Resume<T extends JobRole> {
    T role;

    Resume(T role) {
        this.role = role;
    }

    void evaluate() {
        role.processResume();
    }

    static void screeningPipeline(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            role.processResume();
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer());

        Resume<DataScientist> dsResume = new Resume<>(new DataScientist());

        seResume.evaluate();
        dsResume.evaluate();

        List<JobRole> roleList = new ArrayList<>();
        roleList.add(new SoftwareEngineer());
        roleList.add(new DataScientist());

        screeningPipeline(roleList);
    }
}
