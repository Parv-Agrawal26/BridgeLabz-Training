import java.io.*;
import java.util.*;

public class SortRecords {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("output.csv"))){
            String line;
            if((line = br.readLine())!=null){
                System.out.println(line);
            }
            List<String[]> records = new ArrayList<>();
            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                records.add(columns);
            }
            Collections.sort(records, new Comparator<String[]>() {
                public int compare(String[] a, String[] b) {
                    return a[3].compareTo(b[3]);
                }
            });

            for(String[] record : records){
                System.out.println(String.join(",", record));
            }

        }
        catch(IOException e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}