package com.example.demo.dto;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor

public class VideoDTO {
    private int id;
    private UserDTO user;
    private String name;
    private String thumbnail;
    private int view;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
    private List<ReviewDTO> reviews;

    @Data
    public static class ReviewDTO{
        private String comment;
    }
}
