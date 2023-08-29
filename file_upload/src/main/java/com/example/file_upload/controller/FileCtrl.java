package com.example.file_upload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.file_upload.payload.FileResponse;
import com.example.file_upload.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileCtrl {

    public final FileService fileService;

    @Value("${project.image}")
    public String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadImageHandler(@RequestParam("image") MultipartFile image) {
        String fileName = null;
        try {
            fileName = this.fileService.uploadImage(path, image);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null, "Image not uploaded !!"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new FileResponse(fileName, "Image uploaded successfully !!"), HttpStatus.OK);
    }
}
