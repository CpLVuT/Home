package com.example.familytree.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.familytree.config.ResponseResult;
import com.example.familytree.config.UploadHandler;
import com.example.familytree.entity.FamilyPerson;
import com.example.familytree.entity.PersonView;
import com.example.familytree.service.FamilyPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@Slf4j
public class BaseControler {
    @Autowired
    private FamilyPersonService familyPersonService;

    //可视化图所需数据
    @PostMapping("/getHierarchyList")
    public ResponseResult getHierarchyList(Integer id){
        if (id == null){
            return ResponseResult.success("");
        }
            return familyPersonService.getHierarchyList(id);
    }

    //上传
    @PostMapping("/upload")
    public ResponseResult upload(MultipartFile file) throws Exception {
        String fileName = null;
        if(file!=null&&!file.isEmpty()) {
            fileName= UploadHandler.upload(file);
        }
        return ResponseResult.success("http://localhost:9999/static/"+fileName);
    }
}
