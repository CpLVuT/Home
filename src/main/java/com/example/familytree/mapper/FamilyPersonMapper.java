package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.FamilyPerson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【family_person】的数据库操作Mapper
* @createDate 2023-06-28 14:19:17
* @Entity .FamilyPerson
*/
@Mapper
public interface FamilyPersonMapper extends BaseMapper<FamilyPerson> {
    List<FamilyPerson> getTongjiPersonList(int personId);

    List<FamilyPerson> getZijiPersonList(int personId);

}




