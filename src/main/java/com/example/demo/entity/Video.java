package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="`name`", length = 500, nullable = false)
    private String name;

    @Column(name="`thumbnail`", length = 100, nullable = false)
    private String thumbnail;

    @Column(name="`source`", length = 200, nullable = false)
    private String source;

    @Column(name="`view`")
    private int view;

    @Column(name="`description`", length = 1000)
    private String description;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "video")
    private List<Review> reviews;
}
