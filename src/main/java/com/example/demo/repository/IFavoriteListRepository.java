package com.example.demo.repository;

import com.example.demo.entity.FavoriteList;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavoriteListRepository extends JpaRepository<FavoriteList,Integer> {

    FavoriteList findByUserAndVideo(User user, Video video);
}
