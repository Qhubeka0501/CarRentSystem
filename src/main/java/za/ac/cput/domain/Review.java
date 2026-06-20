package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

/*
 Review.java
 Entity class for customer reviews
 Author: Alphonsine Ningabiye
 Date: 21 June 2026
*/

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    private String reviewId;

    private int rating;

    private String comment;

    private LocalDate reviewDate;

    private String bookingId;

    protected Review() {
    }

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.reviewDate = builder.reviewDate;
        this.bookingId = builder.bookingId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public static class Builder {

        private String reviewId;

        private int rating;

        private String comment;

        private LocalDate reviewDate;

        private String bookingId;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setReviewDate(LocalDate reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}