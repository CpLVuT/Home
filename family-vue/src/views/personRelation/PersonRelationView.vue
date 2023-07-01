<template>
    <div style="text-align: center">
        <!-- 面包屑导航 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>家族关系可视化</el-breadcrumb-item>
        </el-breadcrumb>
        <!-- 搜索筛选 -->
        <el-form :inline="true" :model="formInline" class="user-search">
            <el-form-item label="搜索家族：">
                <el-input size="small" v-model="formInline.id" placeholder="输入家族id"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
            </el-form-item>
        </el-form>
        <TreeChart :json="treeData" style="display: inline-block;"/>
    </div>
</template>
  
<script>
import TreeChart from "vue-tree-chart";
import { PersonRelationHierarchyList } from '../../api/basisMG'

export default {
    components: {
        TreeChart
    },
    data() {
        return {
            treeData: {},
            formInline: {
                id: 1,
                token: localStorage.getItem('logintoken')
            },
            PersonRelationHierarchyList: []

        }
    },
    created() {
        this.getdata(this.formInline)
    },
    methods: {
        getdata(parameter) {
            PersonRelationHierarchyList(parameter)
                .then(res => {
                    this.loading = false
                    if (res.success == false) {
                        this.$message({
                            type: 'info',
                            message: res.msg
                        })
                    } else {
                        this.treeData = res.data
                        console.log(this.treeData)
                    }
                })
                .catch(err => {
                    this.$message.error('菜单加载失败，请稍后再试！')
                })

        }
    }

}
</script>


  
