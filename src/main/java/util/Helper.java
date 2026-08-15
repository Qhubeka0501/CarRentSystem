package util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    public static boolean isStringNull(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean isEmailValid(String email) {
        if (isStringNull(email)) {
            return false;
        }

        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }

    public static boolean isPhoneValid(String phone) {
        if (isStringNull(phone)) {
            return false;
        }

        return phone.matches("^(\\+27|27|0)[6-8][0-9]{8}$");
    }

    public static boolean isStreetAddressValid(String streetNo) {
        if (isStringNull(streetNo)) {
            return false;
        }

        return streetNo.matches("\\d+");
    }
}
