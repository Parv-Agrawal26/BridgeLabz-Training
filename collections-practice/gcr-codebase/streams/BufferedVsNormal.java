import java.io.*;

public class BufferedVsNormal {
    public static void main(String[] args) throws Exception {

        File src = new File("bigfile.dat");

        // Normal stream
        long start1 = System.nanoTime();
        FileInputStream fis1 = new FileInputStream(src);
        FileOutputStream fos1 = new FileOutputStream("normalCopy.dat");

        byte[] buffer = new byte[4096];
        int bytes;
        while ((bytes = fis1.read(buffer)) != -1) {
            fos1.write(buffer, 0, bytes);
        }
        fis1.close();
        fos1.close();
        long end1 = System.nanoTime();

        // Buffered stream
        long start2 = System.nanoTime();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bufferedCopy.dat"));

        while ((bytes = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytes);
        }
        bis.close();
        bos.close();
        long end2 = System.nanoTime();

        System.out.println("Normal time: " + (end1 - start1));
        System.out.println("Buffered time: " + (end2 - start2));
    }
}
