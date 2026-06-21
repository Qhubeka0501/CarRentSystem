package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {

    private String reservationId;
    private String customerId;
    private String vehicleId;
    private LocalDate reservationDate;
    private LocalDate returnDate;
    private PaymentStatus paymentStatus;

    // PRIVATE constructor (IMPORTANT for Builder pattern)
    private Reservation(Builder builder) {

        if (builder.customerId == null || builder.vehicleId == null) {
            throw new IllegalArgumentException("Customer and Vehicle are required");
        }

        if (builder.returnDate.isBefore(builder.reservationDate)) {
            throw new IllegalArgumentException("Return date cannot be before reservation date");
        }

        this.reservationId = UUID.randomUUID().toString();
        this.customerId = builder.customerId;
        this.vehicleId = builder.vehicleId;
        this.reservationDate = builder.reservationDate;
        this.returnDate = builder.returnDate;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    // BUSINESS METHODS (DDD STYLE)

    public void markPaid() {
        this.paymentStatus = PaymentStatus.PAID;
    }

    public void cancel() {
        this.paymentStatus = PaymentStatus.CANCELLED;
    }

    // BUILDER CLASS
    public static class Builder {

        private String customerId;
        private String vehicleId;
        private LocalDate reservationDate;
        private LocalDate returnDate;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder vehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder reservationDate(LocalDate reservationDate) {
            this.reservationDate = reservationDate;
            return this;
        }

        public Builder returnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }

    // GETTERS ONLY (NO SETTERS)

    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
