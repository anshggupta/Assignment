package com.MapMyTour.Assignment.service.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "aws", name = "s3.bucket")
public class  S3ImageStorageService implements ImageStorageService {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Value("${aws.region}")
    private String region;  // <-- add this

    @Override
    public String store(MultipartFile file, String keyPrefix) {
        try {
            String key = keyPrefix + Instant.now().toEpochMilli() + "-" + file.getOriginalFilename();

            PutObjectRequest req = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .contentType(file.getContentType())
                    .build();

            s3Client.putObject(req, RequestBody.fromBytes(file.getBytes()));

            // Use region from application.properties instead of S3Utilities
            return "https://" + bucket + ".s3." + region + ".amazonaws.com/" + key;
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload image to S3", e);
        }
    }
}
