package za.ac.cput.factory;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.NotificationType;
import java.time.LocalDateTime;
import util.Helper;
/*  Class Name: NotificationFactory

     Description: Notification CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 28 June 2026 */

public class NotificationFactory {

    public static Notification createNotification(String notificationId,
                                                  String customerId,
                                                  String bookingId,
                                                  String message,
                                                  LocalDateTime sentAt,
                                                  String notificationType) {
        if (Helper.isStringNull(notificationId)
                || Helper.isStringNull(customerId)
                || Helper.isStringNull(bookingId)
                || Helper.isStringNull(message)
                || sentAt == null
                || Helper.isStringNull(notificationType)) {
            return null;
        }
        if (!Helper.isNotificationTypeValid(notificationType)) {
            return null;
        }

        return new Notification.Builder()
                .setNotificationId(notificationId)
                .setCustomerId(customerId)
                .setBookingId(bookingId)
                .setMessage(message)
                .setSentAt(sentAt)
                .setNotificationType(notificationType)
                .build();
    }

}
