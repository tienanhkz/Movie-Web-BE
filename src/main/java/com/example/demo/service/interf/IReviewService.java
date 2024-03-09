package com.example.demo.service.interf;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.entity.Review;
import com.example.demo.entity.Video;

import java.util.List;

public interface IReviewService {
    List<Review> getReviewsByVideo(Video video);

    void addReview(int id, int videoId, String comment);

    void deleteReview(int id, int reviewId);

    List<Review> findAllReviews();
}
