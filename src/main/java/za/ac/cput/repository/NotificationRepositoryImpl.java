package za.ac.cput.repository;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Payment;

import java.util.HashSet;
import java.util.Set;
/*  Class Name: NotificationRepositoryImpl

     Description: NotificationRepository CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
public class NotificationRepositoryImpl implements NotificationRepository {

    private static NotificationRepositoryImpl repository;

    private final Set<Notification> notificationDB;

    private NotificationRepositoryImpl() {
        notificationDB = new HashSet<>();
    }

    public static NotificationRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new NotificationRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        return null;
    }

    @Override
    public Notification read(Payment paymentId) {
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        return null;
    }

    @Override
    public boolean delete(Payment paymentId) {
        return false;
    }
}
