package com.gutkoski.streamforge.api.storage;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void uploadFile(MultipartFile file, String objectName);
}
