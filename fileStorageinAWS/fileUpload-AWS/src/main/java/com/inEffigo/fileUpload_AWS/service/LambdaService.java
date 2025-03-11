package com.inEffigo.fileUpload_AWS.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class LambdaService {

    private final AWSLambda awsLambda;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${aws.lambda.functionName}")
    private String lambdaFunctionName;

    public LambdaService(@Value("${aws.access.key}") String accessKey,
                         @Value("${aws.secret.key}") String secretKey,
                         @Value("${aws.s3.region}") String region) {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        this.awsLambda = AWSLambdaClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }

    public String sendFileToLambda(File pdfFile) throws Exception {
        byte[] fileBytes = Files.readAllBytes(pdfFile.toPath());
        String base64File = Base64.getEncoder().encodeToString(fileBytes);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("fileName", pdfFile.getName());
        requestBody.put("fileData", base64File);

        Map<String, Object> lambdaEvent = new HashMap<>();
        lambdaEvent.put("body", objectMapper.writeValueAsString(requestBody));

        String payload = objectMapper.writeValueAsString(lambdaEvent);

        InvokeRequest request = new InvokeRequest()
                .withFunctionName(lambdaFunctionName)
                .withPayload(payload);

        InvokeResult result = awsLambda.invoke(request);
        return new String(result.getPayload().array(), StandardCharsets.UTF_8);
    }
}
