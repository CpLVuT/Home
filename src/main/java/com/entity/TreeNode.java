package com.entity;

import com.entity.member;
import java.util.List;
import java.util.ArrayList;
public class TreeNode {
    private member member;//每个节点存一个member
    private List<TreeNode> children;//存放子节点

    public TreeNode(member member) {
        this.member = member;
        this.children = new ArrayList<>();//初始化
    }

    public member getMember() {
        return member;//获取节点中成员
    }

    public void addChild(TreeNode child) {
        children.add(child);//加入新节点
    }

    public List<TreeNode> getChildren() {
        return children;//获取子节点
    }
}