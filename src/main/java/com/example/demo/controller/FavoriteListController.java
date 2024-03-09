package com.example.demo.controller;

import com.example.demo.dto.FavoriteListDTO;
import com.example.demo.entity.FavoriteList;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.repository.IVideoRepository;
import com.example.demo.service.interf.IFavoriteListService;
import com.example.demo.service.interf.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/favorites")
@CrossOrigin("*")
public class FavoriteListController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private IFavoriteListService favoriteListService;

    @GetMapping
    public Page<FavoriteListDTO> getAllFavoriteList(Pageable pageable){
        Page<FavoriteList> favoriteListPage = favoriteListService.getAllFavoriteList(pageable);
        Page<FavoriteListDTO> favoriteListDTOPage = favoriteListPage.map(favoriteList -> modelMapper.map(favoriteList,FavoriteListDTO.class));
        return favoriteListDTOPage;
    }

    @PostMapping("/add/{videoId}")
    public void addToFavorites(Principal principal, @PathVariable int videoId){
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        favoriteListService.addToFavorites(videoId, user.getId());
    }

    @DeleteMapping("/delete/{videoId}")
    public void deleteFromFavorites(Principal principal, @PathVariable int videoId){
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        favoriteListService.deleteFromFavorites(videoId, user.getId());
    }
}
