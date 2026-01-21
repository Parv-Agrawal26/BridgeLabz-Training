public class EmployeeSystem {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 80000);
        Employee developer = new Developer("Bob", 60000);

        System.out.println("Manager: " + manager.getName() + ", Salary: " + manager.getSalary() + ", Bonus: " + manager.getBonus());
        System.out.println("Developer: " + developer.getName() + ", Salary: " + developer.getSalary() + ", Bonus: " + developer.getBonus());

        Employee manager2 = new Manager("Yash", 45000);
        Employee developer2 = new Developer("Rahul", 35000);

        System.out.println("Manager: " + manager2.getName() + ", Salary: " + manager2.getSalary() + ", Bonus: " + manager2.getBonus());
        System.out.println("Developer: " + developer2.getName() + ", Salary: " + developer2.getSalary() + ", Bonus: " + developer2.getBonus());

        try {
            manager.setName("Raj");
        } catch (ValueChangeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            manager.setSalary(95000.0);
        } catch (ValueChangeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
