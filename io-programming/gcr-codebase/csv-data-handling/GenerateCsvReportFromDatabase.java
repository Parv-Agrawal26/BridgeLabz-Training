import java.io.*;
import java.sql.*;

public class GenerateCsvReportFromDatabase {
    private static final String DB_URL = "jdbc:sqlite:employees.db";
    private static final String OUTPUT_FILE = "employees_report.csv";

    public static void main(String[] args) {
        String dbUrl = args.length > 0 ? args[0] : DB_URL;
        String outputFile = args.length > 1 ? args[1] : OUTPUT_FILE;

        String query = "SELECT id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(dbUrl);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                String salary = rs.getString("salary");

                bw.write(id + "," + name + "," + department + "," + salary);
                bw.newLine();
            }

            System.out.println("CSV report generated: " + outputFile);
        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
