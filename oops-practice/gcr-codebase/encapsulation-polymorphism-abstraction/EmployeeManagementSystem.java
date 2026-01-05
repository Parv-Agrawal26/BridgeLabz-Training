import java.util.*;

interface Department {
    void assignDepartment(String departmentName);

    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    abstract double calculateSalary();

    void displayDetails() {
        System.out.println(employeeId + " " + name + " Salary " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String departmentName) {
        department = departmentName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private String department;

    PartTimeEmployee(int id, String name, double rate, int hoursWorked) {
        super(id, name, rate);
        this.hoursWorked = hoursWorked;
    }

    double calculateSalary() {
        return getBaseSalary() * hoursWorked;
    }

    public void assignDepartment(String departmentName) {
        department = departmentName;
    }

    public String getDepartmentDetails() {
        return department;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new FullTimeEmployee(101, "Ravi", 40000);
        employees[1] = new PartTimeEmployee(102, "Anu", 300, 80);

        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
