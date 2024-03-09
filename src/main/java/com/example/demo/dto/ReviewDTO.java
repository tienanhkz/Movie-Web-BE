package com.example.demo.dto;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor

public class ReviewDTO {
    private int id;
    private String comment;
    private User user;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @Data
    public static class User{
        private String username;
    }
}
