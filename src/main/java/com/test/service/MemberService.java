package com.test.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.entity.member;
import com.test.entity.TreeNode;
import com.test.entity.Relation;
import com.test.mapper.MemberMapper;
import com.test.mapper.RelationMapper;
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
