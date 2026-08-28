package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Class Name: ReviewFactoryTest
 * Description: Test for ReviewFactory
 * Author: Alphonsine Ningabiye (230426581)
 */

class ReviewFactoryTest {

    @Test
    void createReview() {

        Review review = ReviewFactory.createReview(
                "C001",
                "Excellent service",
                5
        );

        assertNotNull(review);
        assertNotNull(review.getReviewId());

        assertEquals("C001", review.getCustomerId());
        assertEquals("Excellent service", review.getComments());
        assertEquals(5, review.getRating());
    }
}