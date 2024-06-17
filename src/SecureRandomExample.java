import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecureRandomExample {
    public static void main(String[] args) {
        try {

            SecureRandom sha1prng = SecureRandom.getInstance("SHA1PRNG");
            byte[] sha1prngBytes = new byte[16];
            sha1prng.nextBytes(sha1prngBytes);
            System.out.println("SHA1PRNG: " + Base64.getEncoder().encodeToString(sha1prngBytes));


            SecureRandom nativePrng = SecureRandom.getInstance("NativePRNG");
            byte[] nativePrngBytes = new byte[16];
            nativePrng.nextBytes(nativePrngBytes);
            System.out.println("NativePRNG: " + Base64.getEncoder().encodeToString(nativePrngBytes));


            SecureRandom windowsPrng = SecureRandom.getInstance("Windows-PRNG");
            byte[] windowsPrngBytes = new byte[16];
            windowsPrng.nextBytes(windowsPrngBytes);
            System.out.println("Windows-PRNG: " + Base64.getEncoder().encodeToString(windowsPrngBytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
