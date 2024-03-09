package com.example.demo.service.interf;

import com.example.demo.entity.Video;
import com.example.demo.form.video.CreateVideoForm;
import com.example.demo.form.video.UpdateVideoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVideoService {
    Page<Video> findAllVideos(Pageable pageable);

    Video findVideoByName(String name);

    List<Video> findVideoByNameContaining(String name);

    void createVideo(CreateVideoForm form);

    void updateVideo(UpdateVideoForm form, int id);

    void deleteVideo(int id);

    int findUserIdById(int id);

    Video findVideoById(int id);
}
