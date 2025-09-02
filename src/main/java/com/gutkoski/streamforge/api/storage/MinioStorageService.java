package com.gutkoski.streamforge.api.storage;

import com.gutkoski.streamforge.api.config.MinioProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class MinioStorageService implements StorageService {

    private final S3Client s3Client;
    private final MinioProperties minioProperties;

    public MinioStorageService(S3Client s3Client,
                               MinioProperties minioProperties) {
        this.s3Client = s3Client;
        this.minioProperties = minioProperties;
    }

    @Override
    public void uploadFile(MultipartFile file, String objectName) {
        try {
            s3Client.putObject(
                    builder -> builder.bucket(minioProperties.getBucket())
                            .key(objectName)
                            .build(),
                    RequestBody.fromInputStream(file.getInputStream(), file.getSize())
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file to MinIO", e);
        }
    }
}
