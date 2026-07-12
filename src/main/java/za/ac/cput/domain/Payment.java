package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

/*  Class Name: Payment

     Description: Payment CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 20 May 2026 */

public class Payment {
    private final String paymentId;
    private final String bookingId;
    private final double amount;
    private final LocalDate paymentDate;
    private final String paymentMethod;
    private  String paymentStatus;

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.bookingId = builder.bookingId;
        this.amount = builder.amount;
        this.paymentDate = builder.paymentDate;
        this.paymentMethod = builder.paymentMethod;
        this.paymentStatus = builder.paymentStatus;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void processPayment() {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(amount, payment.amount) == 0 && Objects.equals(paymentId, payment.paymentId) && Objects.equals(bookingId, payment.bookingId) && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(paymentMethod, payment.paymentMethod) && Objects.equals(paymentStatus, payment.paymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, bookingId, amount, paymentDate, paymentMethod, paymentStatus);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", method='" + paymentMethod + '\'' +
                ", status='" + paymentStatus + '\'' +
                '}';
    }

    public String getNotificationType() {
        return null;
    }

    public Payment getNotificationId() {
        return null;
    }

    public static class Builder {
        private String paymentId;
        private String bookingId;
        private double amount;
        private LocalDate paymentDate;
        private String paymentMethod;
        private String paymentStatus;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }

}
