import java.io.*;
public class WriteFile {
    public static void main(String[] args) {
        String filePath = "output.csv";
        String[] data = {"ID,Name,Department,Salary",
                         "1,John Doe,Engineering,60000",
                         "2,Jane Smith,Marketing,55000",
                         "3,Bob Johnson,Sales,50000",
                         "4,Alice Williams,HR,52000",
                         "5,Chris Davis,Finance,58000"};
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for(String line : data){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Data written");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
