import java.io.*;
public class ModifyFile {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("output.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("newData.csv"))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                int sal = Integer.parseInt(columns[3]);
                columns[3] = String.valueOf(sal + (sal/10));
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<columns.length; i++){
                    sb.append(columns[i]);
                    if(i != columns.length - 1){
                        sb.append(",");
                    }
                }
                bw.write(sb.toString());
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
