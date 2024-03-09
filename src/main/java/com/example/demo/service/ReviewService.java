package com.example.demo.service;

import com.example.demo.entity.Review;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.repository.IReviewRepository;
import com.example.demo.service.interf.IReviewService;
import com.example.demo.service.interf.IUserService;
import com.example.demo.service.interf.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ReviewService implements IReviewService {
    @Autowired
    private IReviewRepository reviewRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IVideoService videoService;
    @Override
    public List<Review> getReviewsByVideo(Video video) {
        return reviewRepository.getReviewsByVideo(video);
    }

    @Override
    public void addReview(int id, int videoId, String comment) {
        Review review = new Review();
        User user = userService.findUserById(id);
        Video video = videoService.findVideoById(videoId);
        review.setUser(user);
        review.setVideo(video);
        review.setComment(comment);
        reviewRepository.save(review);
    }

    @Override
    public void deleteReview(int id, int reviewId) {
        User user = userService.findUserById(id);
        Review review = reviewRepository.findReviewById(reviewId);
        if (review.getUser().getId() != user.getId()) {
            return;
        }
        reviewRepository.delete(review);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }
}
