import java.util.Scanner;
import java.io.*;

public class SearchByName {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String searchName = scn.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader("output.csv"))){
            String line;
            boolean found = false;
            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                if(columns[1].equalsIgnoreCase(searchName)){
                    System.out.println("Record Found. Department: " + columns[2] + ", Salary: " + columns[3]);
                    found = true;
                    break;
                }
            }
        }
        catch(IOException e){
            System.out.println("An error occured while reading the file: " + e.getMessage());
        }
    }
}
