package com.example.file_upload.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        // File name
        String name = file.getOriginalFilename();

        // Providing unique random path
        String randomID = UUID.randomUUID().toString();
        String ext = name.substring(name.lastIndexOf("."));

        // Validating the image format
        if (!(ext.equalsIgnoreCase(".png") || ext.equalsIgnoreCase(".jpg") || ext.equalsIgnoreCase(".jpeg")))
            throw new IllegalArgumentException("File name is invalid");

        System.out.println("EXt: " + ext);
        String newName = randomID.concat(ext);

        // Full path
        String filePath = path + File.separator + newName;

        // Create folder if not created
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();

        // Save file in
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return newName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream resource = new FileInputStream(fullPath);
        return resource;
    }

}
