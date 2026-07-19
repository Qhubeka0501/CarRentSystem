package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewControllerTest {

    @Autowired
    private ReviewController controller;

    private static final Review review = ReviewFactory.createReview(
            "R001",
            "C001",
            "Excellent service",
            5
    );

    @Test
    @Order(1)
    void create() {
        Review created = controller.create(review);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Review read = controller.read(review.getReviewId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {

        Review updated = new Review.Builder()
                .copy(review)
                .setComments("Very Good Service")
                .build();

        Review result = controller.update(updated);

        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(controller.getAll());
    }

    @Test
    @Order(5)
    void delete() {

        controller.delete(review.getReviewId());

        Review deleted = controller.read(review.getReviewId());

        assertNull(deleted);
    }
}