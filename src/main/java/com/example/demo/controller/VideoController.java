package com.example.demo.controller;

import com.example.demo.dto.VideoDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.form.video.CreateVideoForm;
import com.example.demo.form.video.UpdateVideoForm;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.interf.IVideoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/videos")
@CrossOrigin("*")
public class VideoController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IVideoService videoService;
    @Autowired
    private IUserRepository userRepository;

    @GetMapping
    public Page<VideoDTO> getAllVideos(Pageable pageable){
        Page<Video> videoPage = videoService.findAllVideos(pageable);
        Page<VideoDTO> videoDTOPage = videoPage.map(video -> modelMapper.map(video,VideoDTO.class));
        return videoDTOPage;
    }

    @GetMapping("/{name}")
    public VideoDTO getVideoByName(@PathVariable String name) {
        Video video = videoService.findVideoByName(name);
        VideoDTO videoDTO = modelMapper.map(video,VideoDTO.class);
        return videoDTO;
    }

    @GetMapping("/search/{name}")
    public List<VideoDTO> getVideosByNameContaining(@PathVariable String name){
        List<Video> videos = videoService.findVideoByNameContaining(name);
        List<VideoDTO> videoDTOs = videos.stream().map(video -> modelMapper.map(video,VideoDTO.class)).collect(Collectors.toList());
        return videoDTOs;
    }

    @PostMapping
    public void createVideo(@RequestBody CreateVideoForm form) {
        Video video = modelMapper.map(form, Video.class);
        videoService.createVideo(form);
    }

    @PutMapping("/{id}")
    public void updateVideo(@RequestBody UpdateVideoForm form, @PathVariable int id) {
        form.setId(id);
        if(form.getCreatedAt() == null){
            form.setCreatedAt(videoService.findVideoById(id).getCreatedAt());
        }
        if (form.getView() == 0) {
            form.setView(videoService.findVideoById(id).getView());
        }
        videoService.updateVideo(form,id);
    }

    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable int id) {
        videoService.deleteVideo(id);
    }
}
