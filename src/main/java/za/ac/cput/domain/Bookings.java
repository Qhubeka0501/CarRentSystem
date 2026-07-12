package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.UUID;
public class Bookings {

    private String bookingId;
    private String customerId;
    private String vehicleId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private PaymentStatus paymentStatus;
    private BookingStatus bookingStatus;

    public Bookings(String customerId, String vehicleId,
                    LocalDate rentalDate, LocalDate returnDate) {

        if (customerId == null || vehicleId == null) {
            throw new IllegalArgumentException("Customer and Vehicle are required");
        }

        if (returnDate.isBefore(rentalDate)) {
            throw new IllegalArgumentException("Return date cannot be before rental date");
        }

        this.bookingId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.paymentStatus = PaymentStatus.PENDING;
        this.bookingStatus = BookingStatus.PENDING;
    }

    // BUSINESS METHODS (THIS IS DDD PART)

    public void confirmBooking() {
        if (bookingStatus == BookingStatus.CANCELLED) {
            throw new IllegalStateException("Cannot confirm a cancelled booking");
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void cancelBooking() {
        this.bookingStatus = BookingStatus.CANCELLED;
    }

    public void markPaid() {
        this.paymentStatus = PaymentStatus.PAID;
    }

    // GETTERS ONLY (NO SETTERS FOR CORE FIELDS)

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}
