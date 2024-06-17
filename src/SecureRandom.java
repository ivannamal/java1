import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.io.IOException;
public class SecureRandom {
    public static void main(String[] args) {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("results.txt", true));
            file.write("\n"+"SecureRandom:" + "\n");

            java.security.SecureRandom sha1prng = java.security.SecureRandom.getInstance("SHA1PRNG");
            byte[] sha1prngBytes = new byte[16];
            sha1prng.nextBytes(sha1prngBytes);
            System.out.println("SHA1PRNG: " + Base64.getEncoder().encodeToString(sha1prngBytes));
            file.write("SHA1PRNG: " + Base64.getEncoder().encodeToString(sha1prngBytes) +"\n");

            java.security.SecureRandom nativePrng = java.security.SecureRandom.getInstance("DRBG");
            byte[] nativePrngBytes = new byte[16];
            nativePrng.nextBytes(nativePrngBytes);
            System.out.println("PKCS11: " + Base64.getEncoder().encodeToString(nativePrngBytes));
            file.write("PKCS11: " + Base64.getEncoder().encodeToString(nativePrngBytes) +"\n");

            java.security.SecureRandom windowsPrng = java.security.SecureRandom.getInstance("Windows-PRNG");
            byte[] windowsPrngBytes = new byte[16];
            windowsPrng.nextBytes(windowsPrngBytes);
            System.out.println("Windows-PRNG: " + Base64.getEncoder().encodeToString(windowsPrngBytes));
            file.write("Windows-PRNG: " + Base64.getEncoder().encodeToString(windowsPrngBytes) +"\n");
            file.close();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
