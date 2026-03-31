import java.io.*;
import java.util.*;

// Requires Jackson (com.fasterxml.jackson.core:jackson-databind)
// Add jackson-databind jar to classpath when compiling/running.
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCsvConverter {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        String jsonPath = args.length > 0 ? args[0] : "students.json";
        String csvPath = args.length > 1 ? args[1] : "students_from_json.csv";
        String jsonOutPath = args.length > 2 ? args[2] : "students_from_csv.json";

        jsonToCsv(jsonPath, csvPath);
        csvToJson(csvPath, jsonOutPath);
    }

    public static void jsonToCsv(String jsonPath, String csvPath) {
        try {
            List<Student> students = MAPPER.readValue(new File(jsonPath), new TypeReference<List<Student>>() {
            });
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath))) {
                bw.write("ID,Name,Age");
                bw.newLine();
                for (Student s : students) {
                    bw.write(s.id + "," + s.name + "," + s.age);
                    bw.newLine();
                }
            }
            System.out.println("JSON to CSV complete: " + csvPath);
        } catch (IOException e) {
            System.out.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }

    public static void csvToJson(String csvPath, String jsonPath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty CSV");
                return;
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (cols.length >= 3) {
                    Student s = new Student();
                    s.id = cols[0].trim();
                    s.name = cols[1].trim();
                    s.age = Integer.parseInt(cols[2].trim());
                    students.add(s);
                }
            }
            MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(jsonPath), students);
            System.out.println("CSV to JSON complete: " + jsonPath);
        } catch (IOException e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }

    static class Student {
        public String id;
        public String name;
        public int age;
    }
}
