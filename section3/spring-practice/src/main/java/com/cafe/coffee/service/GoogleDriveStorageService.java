package com.cafe.coffee.service;

import org.springframework.web.multipart.MultipartFile;

public class GoogleDriveStorageService implements StorageService {
    @Override
    public void store(MultipartFile file) {
        // TODO Google Drive API를 이용해서 AWS S3로 업로드 한다.
    }
}
