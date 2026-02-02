import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : "data.csv";
        Map<String, String> firstOccurrence = new HashMap<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty file");
                return;
            }
            String[] headers = header.split(",");
            int idIndex = findIndex(headers, "ID");
            if (idIndex == -1) {
                System.out.println("ID column not found");
                return;
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length <= idIndex) {
                    continue;
                }
                String id = columns[idIndex].trim();
                if (firstOccurrence.containsKey(id)) {
                    duplicates.add(firstOccurrence.get(id));
                    duplicates.add(line);
                } else {
                    firstOccurrence.put(id, line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found");
        } else {
            System.out.println("Duplicate records:");
            for (String dup : duplicates) {
                System.out.println(dup);
            }
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
