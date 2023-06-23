package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Relation;
import com.example.entity.TreeNode;
import com.example.entity.member;
import com.example.mapper.MemberMapper;
import com.example.mapper.RelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends ServiceImpl<MemberMapper, member> {
    @Autowired//自动装填
    private MemberMapper memberMapper;
    private RelationMapper relationMapper;
    public TreeNode getFamilyTreeById(int member_Id) {
        return memberMapper.getFamilyTreeById(member_Id);//service里一键建树
    }
    public void RebuildFamilytree(int member_id,int relation_id){
        Relation relation=relationMapper.selectById(member_id);
        relation.setRelation_Id(relation_id);
        relationMapper.updateById(relation);
        relationMapper.RebuildFamilyTree(memberMapper,memberMapper.getFamilyTreeById(member_id));
    }
}
