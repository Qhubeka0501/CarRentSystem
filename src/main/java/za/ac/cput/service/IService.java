package za.ac.cput.service;

import za.ac.cput.domain.Payment;
/*  Class Name: IService

     Description: IService CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
public interface IService <P,P1> {
    Payment create(Payment payment);

    Payment read(Payment paymentId);

    Payment update(Payment payment);

    boolean delete(Payment paymentId);
}
