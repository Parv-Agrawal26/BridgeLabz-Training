import java.io.*;

public class PipedExample {
    public static void main(String[] args) throws Exception {

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        Thread writer = new Thread(() -> {
            try {
                pos.write("Hello from thread".getBytes());
                pos.close();
            } catch (IOException e) {
            }
        });

        Thread reader = new Thread(() -> {
            try {
                int d;
                while ((d = pis.read()) != -1) {
                    System.out.print((char) d);
                }
            } catch (IOException e) {
            }
        });

        writer.start();
        reader.start();
    }
}
