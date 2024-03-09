package com.example.demo.service;

import com.example.demo.entity.Video;
import com.example.demo.form.video.CreateVideoForm;
import com.example.demo.form.video.UpdateVideoForm;
import com.example.demo.repository.IVideoRepository;
import com.example.demo.service.interf.IVideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class VideoService implements IVideoService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IVideoRepository videoRepository;
    @Override
    public Page<Video> findAllVideos(Pageable pageable) {
        return videoRepository.findAll(pageable);
    }

    @Override
    public Video findVideoByName(String name) {
        return videoRepository.findByName(name);
    }

    @Override
    public List<Video> findVideoByNameContaining(String name) {
        return videoRepository.findByNameContaining(name);
    }

    @Override
    public void createVideo(CreateVideoForm form) {
        Video video = modelMapper.map(form, Video.class);
        videoRepository.save(video);
    }

    @Override
    public void updateVideo(UpdateVideoForm form, int id) {
        Video video = modelMapper.map(form, Video.class);

        videoRepository.save(video);
    }

    @Override
    public void deleteVideo(int id) {
        videoRepository.deleteById(id);
    }

    @Override
    public int findUserIdById(int id) {
        return videoRepository.findUserIdById(id);
    }

    @Override
    public Video findVideoById(int id) {
        return videoRepository.findById(id).get();
    }

}
