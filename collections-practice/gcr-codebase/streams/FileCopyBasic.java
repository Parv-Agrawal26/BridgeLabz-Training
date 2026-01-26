import java.io.*;

public class FileCopyBasic {
    public static void main(String[] args) {
        File src = new File("source.txt");
        File dest = new File("dest.txt");

        if (!src.exists()) {
            System.out.println("Source file does not exist");
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();
            System.out.println("File copied successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
