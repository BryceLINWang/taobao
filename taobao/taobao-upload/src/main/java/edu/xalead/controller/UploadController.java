package edu.xalead.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {
    @PostMapping("image")
    public ResponseEntity<String> image(MultipartFile file){
        String url = "http://localhost:8080/upload/";
        String contentType=file.getContentType();
        String fileName=file.getOriginalFilename();
        String fon = UUID.randomUUID() + fileName;
        File fe=new File("D:\\jjj\\apache-tomcat-9\\apache-tomcat-9.0.12\\webapps\\upload"+fon);
        try {
            file.transferTo(fe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(url+fon);
    }
}
