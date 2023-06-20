package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper extends BaseMapper<member> {
    public List<member> SelectAll();
}
