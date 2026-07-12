package za.ac.cput.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.NotificationFactory;
import za.ac.cput.service.NotificationServiceImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationServiceImplTest {

    private static final NotificationService service =
            NotificationServiceImpl.getService();

    private static final Notification notification =
            NotificationFactory.createNotification(
                    "N001",
                    "C001",
                    "B001",
                    "Booking confirmed",
                    LocalDateTime.now(),
                    "SMS");

    @Test
    @Order(1)
    void create() {

        Payment created = service.create(notification.getNotificationId());

        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {

        Payment read =
                service.read(notification.getNotificationId());

        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {

        Notification updated =
                NotificationFactory.createNotification(
                        "N001",
                        "C001",
                        "B001",
                        "Booking Updated",
                        LocalDateTime.now(),
                        "Email");

        Payment result = service.update(notification.getNotificationId());

        assertEquals("Email", result.getNotificationType());
    }

    @Test
    @Order(4)
    void delete() {

        assertTrue(service.delete(notification.getNotificationId()));
    }
}