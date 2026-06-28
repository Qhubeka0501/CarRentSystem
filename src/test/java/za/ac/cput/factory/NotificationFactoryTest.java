package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.NotificationType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/*  Class Name: NotificationTypeFactoryTest

     Description: NotificationType CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 28 June 2026 */

class NotificationFactoryTest {

    @Test
    void createNotification() {

        Notification notification = NotificationFactory.createNotification(
                "NOT001",
                "CUS001",
                "BOOK001",
                "Booking confirmed",
                LocalDateTime.now(),
                NotificationType.EMAIL,
        );

        assertNotNull(notification);
        assertEquals("NOT001", notification.getNotificationId());
        assertEquals("CUS001", notification.getCustomerId());

        System.out.println(notification);
    }
}