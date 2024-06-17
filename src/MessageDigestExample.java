import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MessageDigestExample {
    public static void main(String[] args) {
        try {
            String input = "Hello, World!";

            // MD5
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] md5Hash = md5Digest.digest(input.getBytes());
            System.out.println("MD5: " + Arrays.toString(md5Hash));

            // SHA-1
            MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
            byte[] sha1Hash = sha1Digest.digest(input.getBytes());
            System.out.println("SHA-1: " + Arrays.toString(sha1Hash));

            // SHA-256
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
            byte[] sha256Hash = sha256Digest.digest(input.getBytes());
            System.out.println("SHA-256: " + Arrays.toString(sha256Hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
