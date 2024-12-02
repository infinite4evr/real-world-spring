package com.realworld.controller;

import com.realworld.DTO.FileUpload;
import com.realworld.exception.GeneralException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/uploads")
public class UploadController {

  @Value("${upload.directory}")
  private String uploadDir;

  @PostMapping
  public ResponseEntity<Object> uploadImage(@RequestParam("files") List<MultipartFile> files) {

    if (files.isEmpty()) {
      throw new GeneralException("Files is empty");
    }

    Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
    if (!uploadPath.toFile().exists()) {
      uploadPath.toFile().mkdirs();
    }

    List<FileUpload> images = new ArrayList<>();

    files.forEach(
        file -> {
          String fileName = file.getOriginalFilename();
          String filePath = uploadPath.resolve(file.getOriginalFilename()).toString();
          try {
            file.transferTo(new File(filePath));
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
          images.add(FileUpload.builder().id(fileName).url(fileName).build());
        });

    return ResponseEntity.ok().body(images);
  }
}
