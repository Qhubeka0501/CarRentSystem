package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.NotificationFactory;
import za.ac.cput.repository.NotificationRepositoryImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationRepositoryImplTest {

    private static final NotificationRepository repository =
            NotificationRepositoryImpl.getRepository();

    private static final Notification notification =
            NotificationFactory.createNotification(
                    "N001",
                    "C001",
                    "B001",
                    "Booking Confirmed",
                    LocalDateTime.now(),
                    "Email"
            );

    @Test
    @Order(1)
    void create() {

        Payment created = repository.create(notification.getNotificationId());

        assertNotNull(created);
        assertEquals(notification.getNotificationId(), created.getNotificationId());

        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {

        Notification read = repository.read(notification.getNotificationId());

        assertNotNull(read);
        assertEquals(notification.getNotificationId(), read.getNotificationId());

        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {

        Notification updated =
                NotificationFactory.createNotification(
                        "N001",
                        "C001",
                        "B001",
                        "Booking Cancelled",
                        LocalDateTime.now(),
                        "SMS"
                );

        Payment result = repository.update(notification.getNotificationId());

        assertNotNull(result);
        assertEquals("SMS", result.getNotificationType());

        System.out.println(result);
    }

    @Test
    @Order(4)
    void delete() {

        boolean success = repository.delete(notification.getNotificationId());

        assertTrue(success);

        System.out.println("Deleted Successfully");
    }
}