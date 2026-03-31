import java.io.*;
import java.util.*;

public class MergeTwoCsvFiles {
    public static void main(String[] args) {
        String file1 = args.length > 0 ? args[0] : "students1.csv";
        String file2 = args.length > 1 ? args[1] : "students2.csv";
        String output = args.length > 2 ? args[2] : "students_merged.csv";

        Map<String, String[]> baseData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (cols.length >= 3) {
                    baseData.put(cols[0].trim(), new String[] { cols[1].trim(), cols[2].trim() });
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file1 + ": " + e.getMessage());
            return;
        }

        Map<String, String[]> extraData = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (cols.length >= 3) {
                    extraData.put(cols[0].trim(), new String[] { cols[1].trim(), cols[2].trim() });
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file2 + ": " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            Set<String> allIds = new HashSet<>();
            allIds.addAll(baseData.keySet());
            allIds.addAll(extraData.keySet());

            for (String id : allIds) {
                String[] base = baseData.get(id);
                String[] extra = extraData.get(id);
                String name = base != null ? base[0] : "";
                String age = base != null ? base[1] : "";
                String marks = extra != null ? extra[0] : "";
                String grade = extra != null ? extra[1] : "";
                bw.write(id + "," + name + "," + age + "," + marks + "," + grade);
                bw.newLine();
            }
            System.out.println("Merged file created: " + output);
        } catch (IOException e) {
            System.out.println("Error writing output: " + e.getMessage());
        }
    }
}
