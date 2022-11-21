package com.cafe.coffee.service;

import com.cafe.exception.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
public class FileSystemStorageService implements StorageService {
    private final Path root = Paths.get(System.getProperty("user.dir"), "images", "coffee");

    @Override
    public void store(MultipartFile file) {
        // File exist
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file.");
        }

        // Path exist
        Path dst = this.root.resolve(Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
        if (!dst.getParent().equals(this.root.toAbsolutePath())) {
            throw new StorageException("Cannot store file outside current directory.");
        }

        // copy
        // TODO 여려가지 저장 방법 모색해보기. 이미지 수정, 같은 이름 중복 등등...
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, dst, StandardCopyOption.REPLACE_EXISTING);
            log.info("### Store coffee image");
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }
}