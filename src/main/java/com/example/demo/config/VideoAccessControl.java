package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.repository.IUserRepository;
import com.example.demo.repository.IVideoRepository;
import com.example.demo.service.interf.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Optional;

@Component
public class VideoAccessControl {
 @Autowired
 private IVideoRepository videoRepository;

    public boolean canModifyVideo(Authentication authentication, Long videoId) {
        // Kiểm tra xem người dùng đã xác thực hay chưa
        if (authentication != null && authentication.isAuthenticated()) {
            // Lấy username của người dùng đã xác thực
            String username = authentication.getName();

            // Tìm video theo ID
            Optional<Video> optionalVideo = videoRepository.findById(Math.toIntExact(videoId));

            // Kiểm tra xem video có tồn tại hay không
            if (optionalVideo.isPresent()) {
                Video video = optionalVideo.get();
                return video.getUser().getUsername().equals(username);
            }
        }
        return false;
    }

}