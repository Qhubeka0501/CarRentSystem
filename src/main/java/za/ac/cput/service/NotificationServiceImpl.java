package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.NotificationRepository;

/*  Class Name: NotificationServiceImpl

     Description: NotificationService CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
public class NotificationServiceImpl implements NotificationService {

    private static NotificationServiceImpl service;

    private final NotificationRepository repository;

    private NotificationServiceImpl() {
        repository = NotificationRepository.getRepository();
    }

    public static NotificationServiceImpl getService() {

        if (service == null) {
            service = new NotificationServiceImpl();
        }

        return service;
    }


    @Override
    public Payment create(Payment payment) {
        return null;
    }

    @Override
    public Payment read(Payment paymentId) {
        return null;
    }

    @Override
    public Payment update(Review payment) {
        return null;
    }

    @Override
    public boolean delete(Payment paymentId) {
        return false;
    }
}