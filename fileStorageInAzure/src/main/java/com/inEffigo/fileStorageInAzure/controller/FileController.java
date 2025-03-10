package com.inEffigo.fileStorageInAzure.controller;

import com.inEffigo.fileStorageInAzure.entity.FileMetadata;
import com.inEffigo.fileStorageInAzure.repository.FileMetadataRepository;
import com.inEffigo.fileStorageInAzure.service.AzureStorageService;
import com.inEffigo.fileStorageInAzure.service.ExcelServiceReadSave;
import com.inEffigo.fileStorageInAzure.service.FileUploadService;
import com.inEffigo.fileStorageInAzure.service.PdfService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/files")
@Slf4j
public class FileController {


    @Autowired
    private ExcelServiceReadSave excelServiceReadSave;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private AzureStorageService azureStorageService;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private FileMetadataRepository fileMetadataRepository;

    @PostMapping("/process")
    public ResponseEntity<String> processExcel(@RequestParam("file") MultipartFile file){
        try{

            log.info("Processing file: " + file.getOriginalFilename());

            excelServiceReadSave.readExcelAndSaveData(file);

            File pdfFile = pdfService.convertExcelToPdf(file);

            String fileUrl = azureStorageService.uploadFile(pdfFile);

            FileMetadata fileMetadata = new FileMetadata();
            fileMetadata.setFilename(pdfFile.getName());
            fileMetadata.setFileUrl(fileUrl);
            fileMetadataRepository.save(fileMetadata);


            return ResponseEntity.ok("File Processed success: " + fileUrl);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file");
        }
    }
}
