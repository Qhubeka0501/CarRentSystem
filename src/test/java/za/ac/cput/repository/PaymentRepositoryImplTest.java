package za.ac.cput.repository;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.repository.PaymentRepositoryImpl;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentRepositoryImplTest {

    private static final PaymentRepository repository =
            PaymentRepositoryImpl.getRepository();

    private static final Payment payment =
            PaymentFactory.createPayment(
                    "P001",
                    "B001",
                    1500.00,
                    LocalDate.now(),
                    "Card",
                    "Paid"
            );

    @Test
    @Order(1)
    void create() {

        Payment created = repository.create(payment);

        assertNotNull(created);
        assertEquals(payment.getPaymentId(), created.getPaymentId());

        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {

        Notification read = repository.read(payment.getPaymentId());

        assertNotNull(read);
        assertEquals(payment.getPaymentId(), read.getPaymentId());

        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {

        Payment updated =
                PaymentFactory.createPayment(
                        "P001",
                        "B001",
                        2000.00,
                        LocalDate.now(),
                        "EFT",
                        "Completed"
                );

        Payment result = repository.update(updated);

        assertNotNull(result);
        assertEquals("EFT", result.getPaymentMethod());

        System.out.println(result);
    }

    @Test
    @Order(4)
    void delete() {

        boolean success = repository.delete(payment.getPaymentId());

        assertTrue(success);

        System.out.println("Deleted Successfully");
    }
}