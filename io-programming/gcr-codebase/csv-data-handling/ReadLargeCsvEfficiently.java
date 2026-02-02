import java.io.*;
import java.util.*;

public class ReadLargeCsvEfficiently {
    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : "large.csv";
        int batchSize = 100;
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty file");
                return;
            }

            List<String> batch = new ArrayList<>(batchSize);
            String line;
            while ((line = br.readLine()) != null) {
                batch.add(line);
                if (batch.size() == batchSize) {
                    totalCount += batch.size();
                    System.out.println("Processed records: " + totalCount);
                    batch.clear();
                }
            }
            if (!batch.isEmpty()) {
                totalCount += batch.size();
                System.out.println("Processed records: " + totalCount);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
