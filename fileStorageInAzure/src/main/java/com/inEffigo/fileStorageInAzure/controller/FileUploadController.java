package com.inEffigo.fileStorageInAzure.controller;

import com.inEffigo.fileStorageInAzure.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = fileUploadService.uploadFile(file);
            return ResponseEntity.ok(" File uploaded successfully: " + fileUrl);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(" Upload failed: " + e.getMessage());
        }
    }
}

