package com.example.demo.dto;

import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FavoriteListDTO {
    private UserDTO user;
    private VideoDTO video;

    @Data
    public static class UserDTO {
        private String username;
    }

    @Data
    public static class VideoDTO {
        private String name;
    }
}

