package com.example.crawldata.service;

import com.example.crawldata.entity.Image;
import com.example.crawldata.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image getImageById(Long id){
        return imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found image with id: " + id));
    }
}
