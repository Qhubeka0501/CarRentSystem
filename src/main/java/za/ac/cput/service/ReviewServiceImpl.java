package za.ac.cput.service;

import za.ac.cput.domain.Review;

import java.util.HashMap;
import java.util.Map;

public class ReviewServiceImpl implements ReviewService {

    private static ReviewService service = null;
    private final Map<String, Review> reviewDB;

    private ReviewServiceImpl() {
        reviewDB = new HashMap<>();
    }

    public static ReviewService getService() {
        if (service == null) {
            service = new ReviewServiceImpl();
        }
        return service;
    }

    @Override
    public Review create(Review review) {
        reviewDB.put(review.getReviewId(), review);
        return review;
    }

    @Override
    public Review read(String reviewId) {
        return reviewDB.get(reviewId);
    }

    @Override
    public Review update(Review review) {
        if (reviewDB.containsKey(review.getReviewId())) {
            reviewDB.put(review.getReviewId(), review);
            return review;
        }
        return null;
    }

    @Override
    public boolean delete(String reviewId) {
        return reviewDB.remove(reviewId) != null;
    }
}