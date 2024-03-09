package com.example.demo.dto;

import com.example.demo.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String username;
    private String email;
    private int count;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
    private Role role;
    private List<VideoDTO> videos;
    @Data
    public static class VideoDTO{
        private String name;
    }

}
