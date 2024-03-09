package com.example.demo.form.video;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data

public class CreateVideoForm {
//    private User username;
    private String name;
    private String thumbnail;
    private String source;
    private String description;
}
