package com.example.familytree.config;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class UploadHandler {

    //返回图片
    public static String upload(MultipartFile file) throws Exception {

        Date date=new Date();
        //获取事件和为念原始后缀名组合车过一个文件名
        String fileName = "operationtime"+date.getTime()+
                file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        fileName=java.net.URLDecoder.decode(fileName,"utf-8");
        String realPath= ResourceUtils.getURL("classpath:").getPath()+"static/";
        realPath = java.net.URLDecoder.decode(realPath,"utf-8");
        //将文件存入静态位置 这个是存储的真实路径
        byte[] photo;
        //
        photo=file.getBytes();
        //简单的文件输出流，将字节数写入文件。
        FileOutputStream fo=new FileOutputStream(new File(realPath+fileName));
        fo.write(photo);
        fo.flush();
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
