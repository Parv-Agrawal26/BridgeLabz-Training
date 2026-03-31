import java.io.*;
import java.util.*;

public class CsvToObjects {
    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty file");
                return;
            }
            String[] headers = header.split(",");
            int idIndex = findIndex(headers, "ID");
            int nameIndex = findIndex(headers, "Name");
            int ageIndex = findIndex(headers, "Age");

            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length <= Math.max(idIndex, Math.max(nameIndex, ageIndex))) {
                    continue;
                }
                String id = columns[idIndex].trim();
                String name = columns[nameIndex].trim();
                int age = Integer.parseInt(columns[ageIndex].trim());
                students.add(new Student(id, name, age));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static int findIndex(String[] headers, String name) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].trim().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    static class Student {
        private final String id;
        private final String name;
        private final int age;

        public Student(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return "Student{ID=" + id + ", Name=" + name + ", Age=" + age + "}";
        }
    }
}
