import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String dept;
    double salary;

    Employee(int i, String n, String d, double s) {
        id = i;
        name = n;
        dept = d;
        salary = s;
    }
}

public class EmployeeStore {
    public static void main(String[] args) throws Exception {

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Aman", "IT", 50000));
        list.add(new Employee(2, "Ravi", "HR", 40000));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.dat"));
        oos.writeObject(list);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.dat"));
        ArrayList<Employee> data = (ArrayList<Employee>) ois.readObject();

        for (Employee e : data) {
            System.out.println(e.id + " " + e.name + " " + e.dept + " " + e.salary);
        }

        ois.close();
    }
}
