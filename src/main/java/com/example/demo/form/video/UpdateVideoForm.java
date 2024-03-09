package com.example.demo.form.video;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data

public class UpdateVideoForm {
    private int id;
    private User user;
    private String name;
    private int view;
    private String thumbnail;
    private String source;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
}
