package com.hamster.controller;

import com.hamster.comment.RespBeanEnum;
import com.hamster.comment.ResultJson;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title FileUploadController
 * @description <TODO description class purpose>
 * @createTime 2023/7/17 9:40
 **/
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Value("${fileUpload.filePath}")
    private String filePath;

    @PostMapping("/upload")
    public ResultJson upload(MultipartFile file) {

        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));//.png .
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = newFileName + suffix;

        //创建一个文件对象
        File uploadfile = new File(filePath + fileName);

        try {
            file.transferTo(uploadfile);
        } catch (IOException e) {
            return ResultJson.error(RespBeanEnum.ERROR);
        }
        return ResultJson.success(fileName);
    }


    @PostMapping("/compressUpload")
    public ResultJson compressUpload(MultipartFile file) {
//
        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));//.png .
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = newFileName + suffix;

        //创建一个文件对象
        File uploadfile = new File(filePath + fileName);

        //scale 控制图片的大小  参数类型是double 取值范围0~1 如果值为1  表示 压缩后的图片大小是 1：1的
        try {
            Thumbnails.of(file.getInputStream())
                    .scale(0.5f)
                    .outputQuality(0.5)
                    .toFile(uploadfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResultJson.success(fileName);
    }

    @PostMapping("/watermarkUpload")
    public ResultJson watermarkUpload(MultipartFile file) {
        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));//.png .
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = newFileName + suffix;

        //创建一个文件对象
        File uploadfile = new File(filePath + fileName);

        //水印对象
        BufferedImage bi = new BufferedImage(480, 160, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bi.createGraphics();

        //透明区域
        bi = graphics.getDeviceConfiguration().createCompatibleImage(480, 160, Transparency.TRANSLUCENT);

        graphics.dispose();
        graphics = bi.createGraphics();

        // 设置字体类型、大小、加粗、颜色
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 32));
        graphics.setColor(new Color(224, 126, 149));
        //水印显示的字体内容
        char[] data = "徐YN牛逼~".toCharArray();
        // 设置文本显示坐标（0,80）
        graphics.drawChars(data, 0, data.length, 0, 80);
        graphics.dispose();



        //scale 控制图片的大小  参数类型是double 取值范围0~1 如果值为1  表示 压缩后的图片大小是 1：1的
        try {
            Thumbnails.of(file.getInputStream())
                    .scale(0.5f)
                    .watermark(Positions.BOTTOM_CENTER,bi,0.9f)
                    .outputQuality(0.5)
                    .toFile(uploadfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResultJson.success(fileName);
    }
}

