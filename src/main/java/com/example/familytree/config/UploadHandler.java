package com.example.familytree.config;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class UploadHandler {
    //这个类用于前端对家谱头像的上传
    //返回图片
    public static String upload(MultipartFile file) throws Exception {

        Date date=new Date();
        //
        String fileName = "operationtime"+date.getTime()+
                file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String realPath= ResourceUtils.getURL("classpath:").getPath()+"static/";
        //
        byte[] photo;
        //
        photo=file.getBytes();
        //
        FileOutputStream fo=new FileOutputStream(new File(realPath+fileName));
        //
        fo.write(photo);
        //
        fo.flush();
        //
        fo.close();

        return fileName;
    }


    //返回图片存储路径
    public static String modifyUpload(MultipartFile file) throws Exception {


        byte[] photo;
        //
        photo=file.getBytes();
        //
        FileOutputStream fo;
        //
        //
        Date date=new Date();
        //
        String realPath="D:\\cache\\"+"operationtime"+date.getTime()+
                file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //
        fo=new FileOutputStream(new File(realPath));
        //
        fo.write(photo);
        //
        fo.flush();
        //
        fo.close();

        return realPath;
    }

}
