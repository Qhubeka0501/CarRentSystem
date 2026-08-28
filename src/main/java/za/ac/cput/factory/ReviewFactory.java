package za.ac.cput.factory;

import za.ac.cput.domain.Review;

/*
 * Class Name: ReviewFactory
 * Description: Factory for creating Review objects
 * Author: Alphonsine Ningabiye (230426581)
 * Date: 28 June 2026
 */

public class ReviewFactory {

    public static Review createReview(
            String customerId,
            String comments,
            int rating) {

        String reviewId = generateReviewId();

        return new Review.Builder()
                .setReviewId(reviewId)
                .setCustomerId(customerId)
                .setComments(comments)
                .setRating(rating)
                .build();
    }

    private static String generateReviewId() {
        return "REVIEW" + System.currentTimeMillis();
    }
}