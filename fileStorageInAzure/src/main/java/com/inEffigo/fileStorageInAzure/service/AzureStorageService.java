package com.inEffigo.fileStorageInAzure.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class AzureStorageService {

    private final String connectionString = "";
    private final String containerName = "";

    public String uploadFile(File file) throws IOException {

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();

        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(file.getName());

        try (InputStream fileStream = new FileInputStream(file)) {
            blobClient.upload(fileStream, file.length(), true);
        }

        return blobClient.getBlobUrl(); // Return the file URL
    }
}

