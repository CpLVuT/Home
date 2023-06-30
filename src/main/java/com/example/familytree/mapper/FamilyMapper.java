package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.Family;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.ws.soap.MTOM;

/**
* @author admin
* @description 针对表【family】的数据库操作Mapper
* @createDate 2023-06-28 14:19:11
* @Entity .Family
*/
@Mapper
public interface FamilyMapper extends BaseMapper<Family> {

}




