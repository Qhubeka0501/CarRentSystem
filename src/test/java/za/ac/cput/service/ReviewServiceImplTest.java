package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;
import za.ac.cput.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImplTest {

    @Mock
    private ReviewRepository repository;

    private ReviewService service;
    private Review review;

    @BeforeEach
    void setUp() {

        service = new ReviewServiceImpl(repository);

        review = ReviewFactory.createReview(
                "C001",
                "Excellent service",
                5
        );
    }

    @Test
    void create() {

        when(repository.save(review))
                .thenReturn(review);

        Review created = service.create(review);

        assertNotNull(created);
        assertEquals(review.getReviewId(), created.getReviewId());

        verify(repository).save(review);
    }

    @Test
    void read() {

        when(repository.findById(review.getReviewId()))
                .thenReturn(Optional.of(review));

        Review found = service.read(review.getReviewId());

        assertNotNull(found);
        assertEquals(review.getReviewId(), found.getReviewId());

        verify(repository).findById(review.getReviewId());
    }

    @Test
    void update() {

        Review updated = new Review.Builder()
                .copy(review)
                .setComments("Very Good Service")
                .build();

        when(repository.save(updated))
                .thenReturn(updated);

        Review result = service.update(updated);

        assertNotNull(result);
        assertEquals(
                "Very Good Service",
                result.getComments()
        );

        verify(repository).save(updated);
    }

    @Test
    void delete() {

        when(repository.existsById(review.getReviewId()))
                .thenReturn(true);

        doNothing().when(repository)
                .deleteById(review.getReviewId());

        boolean deleted = service.delete(review.getReviewId());

        assertTrue(deleted);

        verify(repository).existsById(review.getReviewId());
        verify(repository).deleteById(review.getReviewId());
    }

    @Test
    void findAll() {

        when(repository.findAll())
                .thenReturn(List.of(review));

        List<Review> result = service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(review.getReviewId(), result.get(0).getReviewId());

        verify(repository).findAll();
    }
}