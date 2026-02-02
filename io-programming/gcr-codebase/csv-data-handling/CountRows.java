import java.io.*;
public class CountRows {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))){
            String line;
            int rowCount = 0;
            while((line = br.readLine()) != null){
                rowCount++;
            }
            System.out.println("Total number of rows excluding header row: " + (rowCount - 1));
        }catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
