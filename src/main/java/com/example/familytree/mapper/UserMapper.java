package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-06-28 14:19:28
* @Entity .User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




