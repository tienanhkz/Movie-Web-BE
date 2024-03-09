package com.example.demo.controller;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.entity.Review;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.service.interf.IReviewService;
import com.example.demo.service.interf.IUserService;
import com.example.demo.service.interf.IVideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/reviews")
@CrossOrigin("*")
public class ReviewController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IReviewService reviewService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IVideoService videoService;
    @GetMapping
    public List<ReviewDTO> getAllReviews() {
    List<Review> reviews = reviewService.findAllReviews();
    List<ReviewDTO> reviewDTOs = reviews.stream().map(review -> modelMapper.map(review, ReviewDTO.class)).collect(Collectors.toList());
    return reviewDTOs;
    }
    @GetMapping("/video/{videoId}")
    public List<ReviewDTO> getReviewsByVideoId(@PathVariable int videoId) {
        Video video = new Video();
        video.setId(videoId);
        List<Review> reviews = reviewService.getReviewsByVideo(video);
        List<ReviewDTO> reviewDTOs = reviews.stream().map(review -> modelMapper.map(review, ReviewDTO.class)).collect(Collectors.toList());
        return reviewDTOs;
    }

    @PostMapping("/add/{videoId}")
    public void createReview(Principal principal, @PathVariable int videoId, @RequestBody String comment) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        reviewService.addReview(user.getId(), videoId, comment);

    }
    @DeleteMapping("/delete/{reviewId}")
    public void deleteReview(Principal principal, @PathVariable int reviewId) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        reviewService.deleteReview(user.getId(), reviewId);
    }
}
