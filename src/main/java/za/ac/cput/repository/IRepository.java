package za.ac.cput.repository;

/*  Class Name: IRepository

     Description: IRepository CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Payment;

public interface IRepository <P, P1> {
    Payment create(Payment payment);
    Notification read(Payment paymentId);
    Payment update(Payment payment);
    boolean delete(Payment paymentId);
}
