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
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email",length = 225,nullable = false)
    private String email;

    @Column(name="username",length = 50,nullable = false)
    private String username;

    @Column(name="`password`",length = 800,nullable = false)
    private String password;

    @Column(name="count")
    private int count = 5;

    @Enumerated(EnumType.STRING)
    @Column(name = "`role`")
    private Role role = Role.USER;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private List<Video> videos;
}
