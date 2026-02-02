import java.io.*;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptDecryptCsv {
    private static final String SECRET_KEY = "1234567890abcdef"; // 16 chars = 128-bit key

    public static void main(String[] args) {
        String input = args.length > 0 ? args[0] : "output.csv";
        String encrypted = args.length > 1 ? args[1] : "output_encrypted.csv";
        String decrypted = args.length > 2 ? args[2] : "output_decrypted.csv";

        encryptCsv(input, encrypted);
        decryptCsv(encrypted, decrypted);
    }

    public static void encryptCsv(String inputPath, String outputPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty file");
                return;
            }
            bw.write(header);
            bw.newLine();

            String[] headers = header.split(",");
            int emailIndex = findIndex(headers, "Email");
            int salaryIndex = findIndex(headers, "Salary");

            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (emailIndex != -1 && emailIndex < cols.length) {
                    cols[emailIndex] = encrypt(cols[emailIndex].trim());
                }
                if (salaryIndex != -1 && salaryIndex < cols.length) {
                    cols[salaryIndex] = encrypt(cols[salaryIndex].trim());
                }
                bw.write(String.join(",", cols));
                bw.newLine();
            }
            System.out.println("Encrypted CSV written: " + outputPath);
        } catch (Exception e) {
            System.out.println("Error encrypting CSV: " + e.getMessage());
        }
    }

    public static void decryptCsv(String inputPath, String outputPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty file");
                return;
            }
            bw.write(header);
            bw.newLine();

            String[] headers = header.split(",");
            int emailIndex = findIndex(headers, "Email");
            int salaryIndex = findIndex(headers, "Salary");

            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (emailIndex != -1 && emailIndex < cols.length) {
                    cols[emailIndex] = decrypt(cols[emailIndex].trim());
                }
                if (salaryIndex != -1 && salaryIndex < cols.length) {
                    cols[salaryIndex] = decrypt(cols[salaryIndex].trim());
                }
                bw.write(String.join(",", cols));
                bw.newLine();
            }
            System.out.println("Decrypted CSV written: " + outputPath);
        } catch (Exception e) {
            System.out.println("Error decrypting CSV: " + e.getMessage());
        }
    }

    private static int findIndex(String[] headers, String name) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].trim().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    private static String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    private static String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(cipherText);
        return new String(cipher.doFinal(decoded), "UTF-8");
    }
}
