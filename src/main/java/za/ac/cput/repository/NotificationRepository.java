package za.ac.cput.repository;

import za.ac.cput.domain.Notification;
/*  Class Name: NotificationRepository

     Description: NotificationRepository CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
public interface NotificationRepository extends IRepository<Notification, String> {

    static NotificationRepository getRepository() {
        return null;
    }
}