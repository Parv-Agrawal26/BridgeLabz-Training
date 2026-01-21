import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    String courseName;

    CourseType(String courseName) {
        this.courseName = courseName;
    }

    abstract void evaluationMethod();
}

class ExamCourse extends CourseType {
    ExamCourse(String name) {
        super(name);
    }

    void evaluationMethod() {
        System.out.println(courseName + " evaluated by exams");
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) {
        super(name);
    }

    void evaluationMethod() {
        System.out.println(courseName + " evaluated by research work");
    }
}

class Course<T extends CourseType> {
    List<T> courses = new ArrayList<>();

    void addCourse(T course) {
        courses.add(course);
    }

    static void showAllCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            c.evaluationMethod();
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> examDept = new Course<>();
        examDept.addCourse(new ExamCourse("Maths"));

        Course<ResearchCourse> researchDept = new Course<>();
        researchDept.addCourse(new ResearchCourse("AI Research"));

        showAllCourses(examDept.courses);
        showAllCourses(researchDept.courses);
    }
}
