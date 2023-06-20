package com.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.member;
import com.entity.TreeNode;
import com.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends ServiceImpl<MemberMapper, member> {
    @Autowired//自动装填
    private MemberMapper memberMapper;
    public TreeNode getFamilyTreeById(int member_Id) {
        return memberMapper.getFamilyTreeById(member_Id);//service里一键建树
    }
    public void Rebuild
}
