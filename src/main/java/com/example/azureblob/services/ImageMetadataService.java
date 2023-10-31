package com.example.azureblob.services;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.example.azureblob.models.ImageMetadata;
import com.example.azureblob.repositories.ImageMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageMetadataService {

    @Autowired
    private ImageMetadataRepository imageMetadataRepository;
    
    @Value("${spring.cloud.azure.storage.blob.container-name}")
    private String containerName;
    
    @Value("${azure.blob-storage.connection-string}")
    private String connectionString;

    public ImageMetadata save(ImageMetadata metadata) {
        return imageMetadataRepository.save(metadata);
    }

    public List<ImageMetadata> findAll() {
        return imageMetadataRepository.findAll();
    }

    public Optional<ImageMetadata> findById(String id) {
        return imageMetadataRepository.findById(id);
    }
    
    public String uploadImageWithCaption(MultipartFile imageFile, String caption) throws IOException {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
        String blobFileName = imageFile.getOriginalFilename();
        BlobClient blobClient = blobServiceClient.getBlobContainerClient(containerName).getBlobClient(blobFileName);

        blobClient.upload(imageFile.getInputStream(), imageFile.getSize(), true);

        String imageUrl = blobClient.getBlobUrl();
        
        ImageMetadata metadata = new ImageMetadata();
        metadata.setCaption(caption);
        metadata.setImageUrl(imageUrl);
        
        imageMetadataRepository.save(metadata);

        return "Image and metadata uploaded successfully!";
    }


}
