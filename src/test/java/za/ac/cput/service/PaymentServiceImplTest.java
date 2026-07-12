package za.ac.cput.service;

import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.service.PaymentServiceImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentServiceImplTest {

    private static final PaymentService service = PaymentServiceImpl.getService();

    private static final Payment payment =
            PaymentFactory.createPayment(
                    "P001",
                    "B001",
                    850.00,
                    LocalDate.now(),
                    "Card",
                    "Paid");

    @Test
    @Order(1)
    void create() {

        Payment created = service.create(payment);

        assertNotNull(created);
        assertEquals(payment.getPaymentId(), created.getPaymentId());
    }

    @Test
    @Order(2)
    void read() {

        Payment read = service.read(payment.getPaymentId());

        assertNotNull(read);
    }

    @Test
    @Order(3)
    void update() {

        Payment updated =
                PaymentFactory.createPayment(
                        "P001",
                        "B001",
                        900,
                        LocalDate.now(),
                        "Cash",
                        "Paid");

        Payment result = service.update(updated);

        assertEquals("Cash", result.getPaymentMethod());
    }

    @Test
    @Order(4)
    void delete() {

        assertTrue(service.delete(payment.getPaymentId()));
    }
}