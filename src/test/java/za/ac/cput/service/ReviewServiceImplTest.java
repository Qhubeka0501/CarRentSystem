package za.ac.cput.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

class ReviewServiceImplTest {

    private ReviewService service;
    private Review review;

    @BeforeEach
    void setUp() {
        service = ReviewServiceImpl.getService();

        review = ReviewFactory.createReview(
                "C001",
                "Excellent service",
                "Excellent service", 8
        );
    }

    @Test
    void create() {
        Review created = service.create(review);

        assertNotNull(created);
        assertEquals(review.getReviewId(), created.getReviewId());
    }

    @Test
    void read() {
        service.create(review);

        Review found = service.read(review.getReviewId());

        assertNotNull(found);
        assertEquals(review.getReviewId(), found.getReviewId());
    }

    @Test
    void update() {
        service.create(review);

        Review updated = new Review.Builder()
                .copy(review)
                .setComments("Very Good Service")
                .build();

        Review result = service.update(updated);

        assertNotNull(result);
        assertEquals("Very Good Service", result.getComments());
    }

    @Test
    void delete() {
        service.create(review);

        boolean deleted = service.delete(review.getReviewId());

        assertTrue(deleted);
    }
}