abstract class Employee {
    private final String name;
    private final double salary;
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    abstract double getBonus();
    String getName() {
        return name;
    }
    double getSalary() {
        return salary;
    }

    void setName(String newName) throws ValueChangeException{
        throw new ValueChangeException("Name change not allowed");
    }

    void setSalary(double newSalary) throws ValueChangeException{
        throw new ValueChangeException("Salary change not allowed");
    }
}
