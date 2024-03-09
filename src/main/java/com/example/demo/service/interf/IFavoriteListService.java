package com.example.demo.service.interf;

import com.example.demo.entity.FavoriteList;
import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFavoriteListService {
    Page<FavoriteList> getAllFavoriteList(Pageable pageable);

    void addToFavorites(int videoId, int id);

    void deleteFromFavorites(int videoId, int id);
}
