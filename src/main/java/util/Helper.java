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

    public static boolean isPaymentMethodValid(String paymentMethod) {
        if (isStringNull(paymentMethod)) {
            return false;
        }
        return paymentMethod.equalsIgnoreCase("Credit Card") ||
                paymentMethod.equalsIgnoreCase("Debit Card") ||
                paymentMethod.equalsIgnoreCase("Cash") ||
                paymentMethod.equalsIgnoreCase("Mobile Payment");
    }

    public static boolean isPaymentStatusValid(String paymentStatus) {
        if (isStringNull(paymentStatus)) {
            return false;
        }
        return paymentStatus.equalsIgnoreCase("Pending") ||
                paymentStatus.equalsIgnoreCase("Completed") ||
                paymentStatus.equalsIgnoreCase("Failed") ||
                paymentStatus.equalsIgnoreCase("Refunded");
    }

    public static boolean isNotificationTypeValid(String notificationType) {
        if (isStringNull(notificationType)) {
            return false;
        }
        return notificationType.equalsIgnoreCase("Email") ||
                notificationType.equalsIgnoreCase("SMS") ||
                notificationType.equalsIgnoreCase("Push Notification");
    }

}
