package com.controller;

import com.entity.member;
import com.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberController {
    @Autowired
    MemberMapper memberMapper;

    public int insert(int Member_Id, String Name, String Sex, String Birth, String Death, int Mother_Id, int Father_ID){

        return memberMapper.insert(new member(Name,Sex,Birth,Death,Member_Id,Mother_Id,Father_ID));
    }
}
