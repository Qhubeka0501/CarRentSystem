package za.ac.cput.factory;
/*  Class Name: PaymentFactory

     Description: PaymentFactory CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 28 June 2026 */

import za.ac.cput.domain.Payment;
import util.Helper;

import java.time.LocalDate;


public class PaymentFactory {
        public static Payment createPayment(String paymentId,
                                            String bookingId,
                                            double amount,
                                            LocalDate paymentDate,
                                            String paymentMethod,
                                            String paymentStatus) {


            if (Helper.isStringNull(paymentId)
                    || Helper.isStringNull(bookingId)
                    || Helper.isStringNull(paymentMethod)
                    || Helper.isStringNull(paymentStatus)
                    || amount <= 0
                    || paymentDate == null) {
                return null;
            }
            if (!Helper.isPaymentMethodValid(paymentMethod)) {
                return null;
            }
            if (!Helper.isPaymentStatusValid(paymentStatus)) {
                return null;
            }

            return new Payment.Builder()
                    .setPaymentId(paymentId)
                    .setBookingId(bookingId)
                    .setAmount(amount)
                    .setPaymentDate(paymentDate)
                    .setPaymentMethod(paymentMethod)
                    .setPaymentStatus(paymentStatus)
                    .build();
        }

    }
