import java.io.*;

public class ConsoleToFile {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("output.txt");

        while (true) {
            String input = br.readLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            fw.write(input + "\n");
        }

        fw.close();
    }
}
