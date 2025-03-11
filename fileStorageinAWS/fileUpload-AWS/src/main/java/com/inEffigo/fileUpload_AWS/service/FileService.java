package com.inEffigo.fileUpload_AWS.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inEffigo.fileUpload_AWS.entity.EmployeeAWS;
import com.inEffigo.fileUpload_AWS.entity.UploadedFileAWS;
import com.inEffigo.fileUpload_AWS.repository.EmployeeRepository;
import com.inEffigo.fileUpload_AWS.repository.UploadedFileRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UploadedFileRepository uploadedFileRepository;

    @Autowired
    private LambdaService lambdaService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final AmazonS3 s3Client;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    public FileService(
                       @Value("${aws.access.key}") String accessKey,
                       @Value("${aws.secret.key}") String secretKey,
                       @Value("${aws.s3.region}") String region) {

        // Initialize S3 Client
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }


//    public String processFile(MultipartFile file) throws Exception{
//
//        List<EmployeeAWS> employeeAWS = extractEmployeeData(file);
//        employeeRepository.saveAll(employeeAWS);
//
//        File pdfFile = convertExcelToPdf(file);
//
//        String s3Url = uploadToS3(pdfFile);
//
//        UploadedFileAWS uploadedFileAWS = new UploadedFileAWS();
//        uploadedFileAWS.setFileName(pdfFile.getName());
//        uploadedFileAWS.setS3Url(s3Url);
//        uploadedFileRepository.save(uploadedFileAWS);
//
//        return "File uploaded to S3 successfully! URL: " + s3Url;
//    }

    public String processFile(MultipartFile file) throws Exception {
        // Step 1: Extract employee data from Excel
        List<EmployeeAWS> employeeAWSList = extractEmployeeData(file);
        employeeRepository.saveAll(employeeAWSList);

        // Step 2: Convert Excel to PDF
        File pdfFile = convertExcelToPdf(file);

        // Step 3: Send PDF to AWS Lambda
        String lambdaResponse = lambdaService.sendFileToLambda(pdfFile);
        if (lambdaResponse.length() > 255) {
            lambdaResponse = lambdaResponse.substring(0, 255); // Trim to 255 characters
        }

        // Step 4: Store file details in DB
        UploadedFileAWS uploadedFileAWS = new UploadedFileAWS();
        uploadedFileAWS.setFileName(pdfFile.getName());
        uploadedFileAWS.setS3Url(lambdaResponse);
        uploadedFileRepository.save(uploadedFileAWS);

        return "File processed successfully! Lambda Response: " + lambdaResponse;
    }

    private List<EmployeeAWS> extractEmployeeData(MultipartFile file) throws Exception {
        List<EmployeeAWS> employees = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Skip header
            EmployeeAWS emp = new EmployeeAWS();
            emp.setName(row.getCell(0).getStringCellValue());
            emp.setEmail(row.getCell(1).getStringCellValue());
            emp.setDepartment(row.getCell(2).getStringCellValue());
            employees.add(emp);
        }

        workbook.close();
        return employees;
    }

    private File convertExcelToPdf(MultipartFile file) throws Exception {
        File pdfFile = File.createTempFile("converted", ".pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pdfFile));

        document.open();
        document.add(new Paragraph("Employee Details"));

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            document.add(new Paragraph(
                    row.getCell(0).getStringCellValue() + " - " +
                            row.getCell(1).getStringCellValue() + " - " +
                            row.getCell(2).getStringCellValue()
            ));
        }

        document.close();
        workbook.close();
        return pdfFile;
    }


//    private String uploadToS3(File file) {
//        String fileName = "uploads/" + file.getName();
//        s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
//        return s3Client.getUrl(bucketName, fileName).toString(); // Return S3 URL
//    }
}
