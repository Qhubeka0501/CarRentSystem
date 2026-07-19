package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.service.PaymentService;

/*  Class Name: PaymentServiceImpl

     Description: PaymentService CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */

public class PaymentServiceImpl implements PaymentService {

    private static PaymentServiceImpl service;

    private final PaymentRepository repository;

    private PaymentServiceImpl() {
        repository = PaymentRepository.getRepository();
    }

    public static PaymentServiceImpl getService() {

        if (service == null) {
            service = new PaymentServiceImpl();
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
    public Payment update(Payment payment) {
        return null;
    }

    @Override
    public boolean delete(Payment paymentId) {
        return false;
    }
}