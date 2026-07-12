package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
/*  Class Name: PaymentRepository

     Description: PaymentRepository CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
public interface PaymentRepository extends IRepository<Payment, String> {

    static PaymentRepository getRepository() {
        return null;
    }

}