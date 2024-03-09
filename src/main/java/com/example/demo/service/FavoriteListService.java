package com.example.demo.service;

import com.example.demo.entity.FavoriteList;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.repository.IFavoriteListRepository;
import com.example.demo.service.interf.IFavoriteListService;
import com.example.demo.service.interf.IUserService;
import com.example.demo.service.interf.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FavoriteListService implements IFavoriteListService {
    @Autowired
    private IFavoriteListRepository favoriteListRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IVideoService videoService;

    @Override
    public Page<FavoriteList> getAllFavoriteList(Pageable pageable) {
        return favoriteListRepository.findAll(pageable);
    }

    @Override
    public void addToFavorites(int videoId, int id) {
        User user = userService.findUserById(id);
        Video video = videoService.findVideoById(videoId);
        FavoriteList existingFavorite = favoriteListRepository.findByUserAndVideo(user, video);
        if (existingFavorite != null) {
            return;
        }
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setUser(user);
        favoriteList.setVideo(video);
        favoriteListRepository.save(favoriteList);
    }

    @Override
    public void deleteFromFavorites(int videoId, int id) {
        User user = userService.findUserById(id);
        Video video = videoService.findVideoById(videoId);
        FavoriteList favoriteList = favoriteListRepository.findByUserAndVideo(user, video);
        if (favoriteList == null) {
            return;
        }
        favoriteListRepository.delete(favoriteList);
    }
}
