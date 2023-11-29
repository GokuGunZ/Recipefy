package Utility;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9]+.[A-Za-z]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isStrongPassword(String password) {
        int minLength = 8;
        if (password.length() < minLength) {
            return false;
        }

        boolean containsDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                containsDigit = true;
            }
        }

        return containsDigit;
    }
}
