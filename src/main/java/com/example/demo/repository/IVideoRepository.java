package com.example.demo.repository;

import com.example.demo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVideoRepository extends JpaRepository<Video, Integer> {
    Video findByName(String name);

    List<Video> findByNameContaining(String name);

    int findUserIdById(int id);

    void findVideoById(int id);
}
