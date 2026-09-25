import java.util.Random;
import java.util.function.Supplier;

public class OTPGenerator {

    public static void main(String[] args) {

        Supplier<String> generateOTP = () -> {

            Random r = new Random();
            char[] vowels = {'A', 'E', 'I', 'O', 'U'};

            // Generate first character
            char firstChar = vowels[r.nextInt(vowels.length)];

            // Generate 4 random digits
            String otp = "" + firstChar;

            for (int i = 0; i < 4; i++) {
                otp = otp + r.nextInt(10);
            }

            return otp;
        };

        System.out.println("OTP: " + generateOTP.get());
    }
}