package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.Objects;


/*  Class Name: Notification

     Description: Notification CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 20 June 2026 */

public class Notification {
    private final String notificationId;
    private final String customerId;
    private final String bookingId;
    private final String message;
    private final LocalDateTime sentAt;
    private final String notificationType;


    private Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.customerId = builder.customerId;
        this.bookingId = builder.bookingId;
        this.message = builder.message;
        this.sentAt = builder.sentAt;
        this.notificationType = builder.notificationType;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public String getNotificationType() {
        return notificationType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(notificationId, that.notificationId) && Objects.equals(customerId, that.customerId) && Objects.equals(bookingId, that.bookingId) && Objects.equals(message, that.message) && Objects.equals(sentAt, that.sentAt) && Objects.equals(notificationType, that.notificationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, customerId, bookingId, message, sentAt, notificationType);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", message='" + message + '\'' +
                ", sentAt=" + sentAt +
                ", type='" + notificationType + '\'' +
                '}';
    }

    public Payment getPaymentId() {
        return null;
    }

    public static class Builder {
        private String notificationId;
        private String customerId;
        private String bookingId;
        private String message;
        private LocalDateTime sentAt;
        private String notificationType;

        public Builder setNotificationId(String notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setSentAt(LocalDateTime sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        public Builder setNotificationType(String notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }

}
