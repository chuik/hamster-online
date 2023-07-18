package com.hamster.controller;

import com.hamster.comment.RespBeanEnum;
import com.hamster.comment.ResultJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Value("${fileUpload.filePath}")
    private String filePath;

    @RequestMapping("/upload")
    public ResultJson upload(MultipartFile file){

        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replaceAll("-","");
        String fileName = newFileName+suffix;

        //创建一个文件对象
        File uploadFile = new File(filePath+fileName);
        try{
            file.transferTo(uploadFile);
        }catch (IOException e){
            return ResultJson.error(RespBeanEnum.ERROR);
        }

        return ResultJson.success(fileName);
    }
}
