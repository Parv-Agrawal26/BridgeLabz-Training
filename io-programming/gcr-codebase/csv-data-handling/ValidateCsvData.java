import java.io.*;
import java.util.regex.*;

public class ValidateCsvData {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : "data.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty file");
                return;
            }
            String[] headers = header.split(",");
            int emailIndex = findIndex(headers, "Email");
            int phoneIndex = findIndex(headers, "Phone") != -1 ? findIndex(headers, "Phone")
                    : findIndex(headers, "Phone Numbers");

            if (emailIndex == -1 || phoneIndex == -1) {
                System.out.println("Required columns not found: Email and Phone/Phone Numbers");
                return;
            }

            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] columns = line.split(",");
                if (columns.length <= Math.max(emailIndex, phoneIndex)) {
                    System.out.println("Invalid row (missing columns) at line " + lineNumber + ": " + line);
                    continue;
                }
                String email = columns[emailIndex].trim();
                String phone = columns[phoneIndex].trim();

                boolean emailValid = EMAIL_PATTERN.matcher(email).matches();
                boolean phoneValid = PHONE_PATTERN.matcher(phone).matches();

                if (!emailValid || !phoneValid) {
                    String reason = (!emailValid ? "Invalid Email" : "") + (!emailValid && !phoneValid ? " and " : "")
                            + (!phoneValid ? "Invalid Phone" : "");
                    System.out.println("Invalid row (" + reason + ") at line " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
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
}
