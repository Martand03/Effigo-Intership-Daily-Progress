package com.inEffigo.fileStorageInAzure.controller;

import com.inEffigo.fileStorageInAzure.service.ExcelServiceReadSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/excel")
public class ExcellController {

    @Autowired
    private ExcelServiceReadSave excelServiceReadSave;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        try{
            excelServiceReadSave.readExcelAndSaveData(file);
            return ResponseEntity.ok("Excel data saved successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process Excel");
        }
    }
}
