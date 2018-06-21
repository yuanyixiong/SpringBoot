/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo;

import online.shixun.utile.ImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/***
 * nginx 文件管理程序
 */
@SpringBootApplication
@RestController
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    //nginx 文件服务器目录
    @Value("${system.file.images.service.upload}")
    private String fileDirectory;


    /**
     * 上传商品图片，图片会被压缩成三份(850*1036,420*512,100*122)进行保存
     *
     * @param file    上传的文件
     * @param request
     * @return 压缩后保存的三个文件的文件名
     */
    @PostMapping("/uploadProductFile")
    public String uploadProductFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //构建文件服务器，文件存放路径
        if (!new File(fileDirectory).exists()) {
            new File(fileDirectory).mkdirs();
        }
        File max = null, med = null, min = null;
        try {
            //压缩成850*1036大小的图片
            logger.info(String.format("%s%s%s", fileDirectory, "850-1036", file.getOriginalFilename()));
            max = new File(String.format("%s%s%s", fileDirectory, "850-1036", file.getOriginalFilename()));
            ImageUtils.thumbnail(file.getInputStream(), 850, 1036, max);

            //压缩成420*512大小的图片
            logger.info(String.format("%s%s%s", fileDirectory, "420-512", file.getOriginalFilename()));
            med = new File(String.format("%s%s%s", fileDirectory, "420-512", file.getOriginalFilename()));
            ImageUtils.thumbnail(file.getInputStream(), 420, 512, med);

            //压缩成100*122大小的图片
            logger.info(String.format("%s%s%s", fileDirectory, "100-122", file.getOriginalFilename()));
            min = new File(String.format("%s%s%s", fileDirectory, "100-122", file.getOriginalFilename()));
            ImageUtils.thumbnail(file.getInputStream(), 100, 122, min);


        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(String.format("%s,%s,%s", max.getName(), med.getName(), min.getName()));
        return String.format("%s,%s,%s", max.getName(), med.getName(), min.getName());
    }


    /**
     * 上传文件到服务器,数据不保存数据库
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //构建文件服务器，文件存放路径
        if (!new File(fileDirectory).exists()) {
            new File(fileDirectory).mkdirs();
        }
        String filePath;
        try {
            //保存的文件
            filePath = String.format("%s%s", fileDirectory, file.getOriginalFilename());
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 删除nginx服务器文件
     *
     * @param fileName 要删除的文件[文件名]
     * @return
     */
    @GetMapping("/deleteFile")
    public String deleteFile(String fileName) {
        if (new File(String.format("%s%s", fileDirectory, fileName)).exists()) {
            new File(String.format("%s%s", fileDirectory, fileName)).delete();
            return "success";
        }
        return "error";
    }

}
