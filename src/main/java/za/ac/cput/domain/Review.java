package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * Class Name: Review.java
 * Description: Review CarRentSystem Class
 * Author: Alphonsine Ningabiye (230426581)
 * Date: 21 June 2026
 */

@Entity
public class Review {

    @Id
    private String reviewId;

    private String customerId;
    private String comments;
    private int rating;


    protected Review() {
    }

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.customerId = builder.customerId;
        this.comments = builder.comments;
        this.rating = builder.rating;
    }

    public String getReviewId() {
        return reviewId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", comments='" + comments + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static class Builder {

        private String reviewId;
        private String customerId;
        private String comments;
        private int rating;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setComments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.customerId = review.customerId;
            this.comments = review.comments;
            this.rating = review.rating;
            return this;
        }

        public Review build() {

            return new Review(this);
        }
    }
}