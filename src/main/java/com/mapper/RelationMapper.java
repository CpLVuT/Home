package com.mapper;

import com.entity.TreeNode;
import com.entity.member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.Relation;
import org.springframework.stereotype.Repository;

public interface RelationMapper extends BaseMapper<Relation> {
    default void RebuildFamilyTree(MemberMapper memberMapper, TreeNode node) {
        int member_Id = node.getMember().getMember_Id();
        // 查询关系表中当前成员的变更情况
        Relation relation =selectById(member_Id);
        int relationId =relation.getRelation_Id();
        // 根据relationId进行相应的处理
        if (relationId == 0) {
            member member = node.getMember();

            // 将对应成员的Mother_id或Father_id置为0
            if (memberMapper.selectById(relation.getMember_Id2()).getSex().equals("女"))
            member.setMother_ID(0);
            else if(memberMapper.selectById(relation.getMember_Id2()).getSex().equals("女"))
            member.setFather_ID(0);
            // 更新数据库中对应成员的Mother_id和Father_id字段
            updateById(member);

            // 调用MemberMapper接口中的方法构造树
            memberMapper.buildFamilyTree(node);
        }
    }
}
