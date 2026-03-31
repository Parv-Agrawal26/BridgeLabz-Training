import java.io.*;

public class StudentData {
    public static void main(String[] args) throws Exception {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"));
        dos.writeInt(101);
        dos.writeUTF("Rahul");
        dos.writeDouble(8.5);
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"));
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readDouble());
        dis.close();
    }
}
