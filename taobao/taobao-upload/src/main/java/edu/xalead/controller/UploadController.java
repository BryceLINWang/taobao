package edu.xalead.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {
    @Resource
    private FastFileStorageClient storageClient;

    @Resource
    private ThumbImageConfig thumbImageConfig;
    @PostMapping("image")
    public ResponseEntity<String> image(MultipartFile file){
        String url = "http://image.taobao.com/";
        String contentType=file.getContentType();
        String fullPath = null;
        try {
            InputStream inputStream = file.getInputStream();
            StorePath storePath = storageClient.uploadFile(inputStream, file.getSize(), "jpg", null);
            fullPath = storePath.getFullPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(url + fullPath);
    }
}
