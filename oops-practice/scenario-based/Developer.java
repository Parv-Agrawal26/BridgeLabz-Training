abstract class Employee {

    private final String name;
    private final double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }

    abstract double getBonus();
}

class Manager extends Employee {

    Manager(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return getSalary() * 0.10;
    }
}

class Developer extends Employee {

    Developer(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return getSalary() > 50000 ? getSalary() * 0.05 : 0.0;
    }

    public static void main(String[] args) {

        Employee manager = new Manager("Alice", 80000);
        System.out.printf("%.2f%n", manager.getBonus());
    }
}
