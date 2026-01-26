import java.io.*;

public class ImageCopy {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("img.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int b;
        while ((b = fis.read()) != -1) {
            baos.write(b);
        }

        byte[] imageBytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream("newimg.jpg");

        while ((b = bais.read()) != -1) {
            fos.write(b);
        }

        fis.close();
        fos.close();
        System.out.println("Image copied");
    }
}
