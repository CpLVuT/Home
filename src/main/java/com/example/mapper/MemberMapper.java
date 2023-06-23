package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.TreeNode;
import com.example.entity.member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;


@Mapper
public interface MemberMapper extends BaseMapper<member> {
    default void buildFamilyTree(TreeNode Node){
        int member_Id = Node.getMember().getMember_Id();//获取成员id
        List<member> children = selectList(new QueryWrapper<member>()
                .eq("father_id", member_Id)
                .or()
                .eq("mother_id", member_Id));

        for (member child : children) {
            TreeNode childNode = new TreeNode(child);
            Node.addChild(childNode);
            buildFamilyTree(childNode);
        }
    }
    default TreeNode getFamilyTreeById(int member_Id) {
        member initMember = selectById(member_Id);//通过id查找成员
        TreeNode rootNode = new TreeNode(initMember);//用该成员建立一个树对象
        buildFamilyTree(rootNode);//深搜建树
        return rootNode;
    }

}
