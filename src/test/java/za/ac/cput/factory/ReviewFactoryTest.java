package za.ac.cput.factory;

/* Class Name: Review.java
 *Description: Review CarRentSystem Class
 * Author: Alphonsine Ningabiye(230426581)
 * Date: 21 June 2026
 */

import static org.junit.jupiter.api.Assertions.*;

/* Class Name: Review.java
 *Description: Review CarRentSystem Class
 * Author: Alphonsine Ningabiye(230426581)
 * Date: 28 June 2026
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;

class ReviewFactoryTest {

    @Test
    void createReview() {

        Review review = ReviewFactory.createReview(
                "C01",
                "Excellent service",
                4
        );

        assertNotNull(review);
        assertNotNull(review.getReviewId());

        System.out.println(review);
    }
}