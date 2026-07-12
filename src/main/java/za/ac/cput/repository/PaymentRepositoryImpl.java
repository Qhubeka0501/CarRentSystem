package za.ac.cput.repository;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Payment;

import java.util.HashSet;
import java.util.Set;
/*  Class Name: PaymentRepositoryImpl

     Description: PaymentRepository CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
public class PaymentRepositoryImpl implements PaymentRepository {

    private static PaymentRepositoryImpl repository;

    private final Set<Payment> paymentDB;

    private PaymentRepositoryImpl() {
        paymentDB = new HashSet<>();
    }

    public static PaymentRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new PaymentRepositoryImpl();
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