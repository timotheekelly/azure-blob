package com.example.azureblob.controllers;

import com.example.azureblob.models.ImageMetadata;
import com.example.azureblob.services.ImageMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/image-metadata")
public class ImageMetadataController {

    @Autowired
    private ImageMetadataService imageMetadataService;
    
    @PostMapping("/upload")
    public String uploadImageWithCaption(@RequestParam("image") MultipartFile imageFile, @RequestParam("caption") String caption) throws IOException {
        return imageMetadataService.uploadImageWithCaption(imageFile, caption);
    }

    @GetMapping("/")
    public List<ImageMetadata> getAllImageMetadata() {
        return imageMetadataService.findAll();
    }

    @GetMapping("/{id}")
    public ImageMetadata getImageMetadataById(@PathVariable String id) {
        return imageMetadataService.findById(id).orElse(null);
    }

}
