public class Manager extends Employee {
    Manager(String name, int age, String department, double salary) {
        super(name, age);
        super.department = department;
        super.salary = salary;
    }
}
