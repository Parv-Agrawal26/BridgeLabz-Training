import java.io.*;
public class FilterRecords {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))){
            String line;
            if((line = br.readLine())!=null){
                System.out.println(line);
            }
            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[3]);
                if(marks > 80){
                    System.out.println(line);
                }
            }
        }
        catch(IOException e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
