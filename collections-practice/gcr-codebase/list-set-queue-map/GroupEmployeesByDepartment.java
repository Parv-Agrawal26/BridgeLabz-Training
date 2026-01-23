import java.util.*;

public class GroupEmployeesByDepartment {

    static class Employee {
        String name;
        String dept;

        Employee(String name, String dept) {
            this.name = name;
            this.dept = dept;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static Map<String, List<Employee>> groupByDept(List<Employee> employees) {
        Map<String, List<Employee>> deptMap = new HashMap<>();

        for (Employee e : employees) {
            deptMap
                    .computeIfAbsent(e.dept, k -> new ArrayList<>())
                    .add(e);
        }

        return deptMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Asha", "IT"),
                new Employee("Ravi", "HR"),
                new Employee("Neha", "IT")
        );

        System.out.println(groupByDept(employees));
    }
}
