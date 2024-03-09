package com.example.demo.repository;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.entity.Review;
import com.example.demo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> getReviewsByVideo(Video video);

    Review findReviewById(int reviewId);
}
