import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class MessageDigest {
    public static void main(String[] args) {
        try {
            String input = "My name is Ivanna.";
            BufferedWriter file = new BufferedWriter(new FileWriter("results.txt", true));
            file.write("MessageDigest:" + "\n");
            java.security.MessageDigest obj1 = java.security.MessageDigest.getInstance("MD5");
            //The update() method accepts data in the form of the byte array.
            obj1.update(input.getBytes());
            byte[] hash1 = obj1.digest();
            System.out.println(hash1);
            file.write("MD5: "+hash1.toString() + "\n");

            java.security.MessageDigest obj2 = java.security.MessageDigest.getInstance("SHA-1");
            obj2.update(input.getBytes());
            byte[] hash2 = obj2.digest();
            System.out.println(hash2);
            file.write("SHA-1: " + hash1.toString() + "\n");

            java.security.MessageDigest obj3 = java.security.MessageDigest.getInstance("SHA-256");
            obj3.update(input.getBytes());
            byte[] hash3 = obj3.digest();
            System.out.println(hash3);
            file.write("SHA-256: " + hash1.toString() + "\n");
            file.write("\n");
             file.close();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
