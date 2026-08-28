package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import za.ac.cput.domain.Review;
import za.ac.cput.service.ReviewService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
 * Class Name: ReviewControllerTest
 * Description: Controller test for Review
 * Author: Alphonsine Ningabiye (230426581)
 * Date: 23 August 2026
 */

@WebMvcTest(ReviewController.class)
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ReviewService reviewService;

    private Review createReview() {

        return new Review.Builder()
                .setReviewId("REV001")
                .setCustomerId("C001")
                .setComments("Excellent service")
                .setRating(5)
                .build();
    }

    @Test
    void create() throws Exception {

        Review review = createReview();

        when(reviewService.create(any(Review.class)))
                .thenReturn(review);

        mockMvc.perform(post("/review/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(review)))
                .andExpect(status().isOk());

        verify(reviewService)
                .create(any(Review.class));
    }

    @Test
    void read() throws Exception {

        Review review = createReview();

        when(reviewService.read("REV001"))
                .thenReturn(review);

        mockMvc.perform(get("/review/read/REV001"))
                .andExpect(status().isOk());

        verify(reviewService)
                .read("REV001");
    }

    @Test
    void update() throws Exception {

        Review review = createReview();

        when(reviewService.update(any(Review.class)))
                .thenReturn(review);

        mockMvc.perform(put("/review/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(review)))
                .andExpect(status().isOk());

        verify(reviewService)
                .update(any(Review.class));
    }

    @Test
    void delete() throws Exception {

        when(reviewService.delete("REV001"))
                .thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/review/delete/REV001"))
                .andExpect(status().isOk());

        verify(reviewService)
                .delete("REV001");
    }

    @Test
    void getAll() throws Exception {

        Review review = createReview();

        when(reviewService.findAll())
                .thenReturn(List.of(review));

        mockMvc.perform(get("/review/getAll"))
                .andExpect(status().isOk());

        verify(reviewService)
                .findAll();
    }
}