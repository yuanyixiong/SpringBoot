/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.module.product.controller;

import online.shixun.demo.eshopadmin.core.controller.BaseController;
import online.shixun.demo.eshopadmin.core.response.ResponseData;
import online.shixun.demo.eshopadmin.core.service.BaseServiceAbstractPage;
import online.shixun.demo.eshopadmin.core.service.BeanEnum;
import online.shixun.demo.eshopadmin.core.service.ImgEnum;
import online.shixun.demo.eshopadmin.core.service.UploadFileNginxService;
import online.shixun.demo.eshopadmin.model.EshopImgModel;
import online.shixun.demo.eshopadmin.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/shopping/mall/img")
public class EshopImgController extends BaseController<EshopImgModel, String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${system.file.images.suffix.include}")
    private String include;//包含的图片类型  案例：.jpg|.png|.gif


    @Value("${system.file.images.service.nginxVisitURL}")
    private String nginxVisitURL;

    //文件服务
    private UploadFileNginxService uploadFileNginxService;

    public EshopImgController(@Qualifier("eshopImgService") BaseServiceAbstractPage baseServiceAbstractPage,
                              @Qualifier("uploadFileNginx") UploadFileNginxService uploadFileNginxService) {
        super(baseServiceAbstractPage);
        this.uploadFileNginxService = uploadFileNginxService;
    }

    @Override
    public String getMainPageUrl() {
        return null;
    }

    @Override
    public String getFromPageUrl() {
        return null;
    }

    @Override
    public Sort getPagesSort() {
        return null;
    }


    /**
     * 上传文件到服务器,数据不保存数据库
     *
     * @param files
     * @return
     */
    @PostMapping("/uploadProductFile")
    public ResponseData uploadProductFile(@RequestParam("files") MultipartFile[] files) {
        List<EshopImgModel> images = new ArrayList<>();
        ResponseData responseData = new ResponseData();
        for (MultipartFile file : files) {
            try {
                // 保存的文件名格式：数据id - 随机编码.允许的后缀
                String id = BeanUtils.getId();
                String fileName = file.getOriginalFilename().replaceFirst(String.format("\\w+[%s]", include), String.format("%s.", id));//替换文件名
                logger.info("上传文件到nginx文件服务器");
                String serviceFileName = uploadFileNginxService.upload("uploadProductFile", "file", fileName, file.getInputStream());
                logger.info("完成文件上传");
                images.add(new EshopImgModel(id, BeanEnum.UNDEL.getIndex(), new Date(), new Date(), serviceFileName, ImgEnum.UNDEF.getIndex(), file.getOriginalFilename()));
                responseData.setData(images);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseData;
    }

    /**
     * 上传文件到服务器,数据不保存数据库
     *
     * @param files
     * @return
     */
    @PostMapping("/uploadFile")
    public ResponseData uploadFile(@RequestParam("files") MultipartFile[] files) {
        List<EshopImgModel> images = new ArrayList<>();
        ResponseData responseData = new ResponseData();
        for (MultipartFile file : files) {
            try {
                // 保存的文件名格式：数据id - 随机编码.允许的后缀
                String id = BeanUtils.getId();
                String fileName = file.getOriginalFilename().replaceFirst(String.format("\\w+[%s]", include), String.format("%s.", id));//替换文件名
                logger.info("上传文件到nginx文件服务器");
                uploadFileNginxService.upload("uploadFile", "file", fileName, file.getInputStream());
                logger.info("完成文件上传");
                images.add(new EshopImgModel(id, BeanEnum.UNDEL.getIndex(), new Date(), new Date(),fileName, ImgEnum.UNDEF.getIndex(), file.getOriginalFilename()));
                responseData.setData(images);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseData;
    }

    /**
    /**
     * 删除服务器文件,数据不保存数据库
     *
     * @param url
     * @return
     */
    @PostMapping("/deleteProductFile")
    public ResponseData deleteProductFile(String key,String url) {
        if(Objects.nonNull(key)){
            try {
                baseServiceAbstractPage.deleteModel(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ResponseData responseData = new ResponseData();
        Arrays.stream(url.split(",")).forEach(fileName -> {
            logger.info("删除nginx文件服务器的文件");
            uploadFileNginxService.sendGET("deleteFile", String.format("fileName=%s", fileName));
        });
        return responseData;
    }
}