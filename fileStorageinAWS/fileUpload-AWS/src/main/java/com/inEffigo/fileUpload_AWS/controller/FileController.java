package com.inEffigo.fileUpload_AWS.controller;

import com.inEffigo.fileUpload_AWS.service.FileService;
import com.inEffigo.fileUpload_AWS.service.LambdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private LambdaService lambdaService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){

        try{

            String response = fileService.processFile(file);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing file: " + e.getMessage());
        }

    }


//    @PostMapping("/lambda")
//    public ResponseEntity<String> uploadViaLambda(@RequestParam("file") MultipartFile file){
//        try{
//            String response = lambdaService.sendFileToLambda(file);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Error: " + e.getMessage());
//        }
//    }

}
