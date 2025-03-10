package com.inEffigo.fileStorageInAzure.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.azure.storage.blob.*;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FileUploadService {
    private final String connectionString = "";
    private final String containerName = "";

    public String uploadFile(MultipartFile file) throws IOException {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();

        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(file.getOriginalFilename());

        try (InputStream inputStream = file.getInputStream()) {
            blobClient.upload(inputStream, file.getSize(), true);
        }

        return blobClient.getBlobUrl(); // Return the file URL
    }
}
