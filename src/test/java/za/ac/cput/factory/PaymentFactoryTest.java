package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.PaymentStatus;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/*  Class Name: PaymentFactoryTest

     Description: PaymentFactory CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 28 June 2026 */

class PaymentFactoryTest {

    @Test
    void createPayment() {

        Payment payment = PaymentFactory.createPayment(
                "PAY001",
                "BOOK001",
                2500.00,
                LocalDate.now(),
                PaymentMethod.CARD,
                PaymentStatus.COMPLETED,
        );

        assertNotNull(payment);
        assertEquals("PAY001", payment.getPaymentId());
        assertEquals("BOOK001", payment.getBookingId());

        System.out.println(payment);
    }
}