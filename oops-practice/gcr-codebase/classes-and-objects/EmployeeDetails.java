public class EmployeeDetails {
    private String name;
    private int id;
    private int salary;

    EmployeeDetails(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void printDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee salary: " + salary);
    }

    public static void main(String[] args) {
        EmployeeDetails emp1 = new EmployeeDetails("Parv", 101, 999999999);
        EmployeeDetails emp2 = new EmployeeDetails("Raj", 102, 60000);
        emp1.printDetails();
        System.out.println();
        emp2.printDetails();
    }
}
