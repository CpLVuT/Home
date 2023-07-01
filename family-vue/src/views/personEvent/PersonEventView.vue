<template>
    <div>
        <!-- 面包屑导航 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>家族关系可视化</el-breadcrumb-item>
        </el-breadcrumb>
        <!-- 搜索筛选 -->
        <el-form :inline="true" :model="formInline" class="user-search">
            <el-form-item label="搜索成员id：">
                <el-input size="small" v-model="formInline.id" placeholder="输入成员id"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
            </el-form-item>
        </el-form>
        <light-timeline :items='lineData'>
        </light-timeline>
    </div>
</template>
  
<script>
import VueLightTimeline from 'vue-light-timeline';
import { PersonEventView } from '../../api/basisMG'

export default {
    data() {
        return {
            items: [
                {
                    tag: '2019-02-12',
                    content: '测试内容', description: 'Event 1',
                    htmlMode: true,
                    content: `<div> =v = </div>`
                },
                {
                    tag: '2019-02-13',
                    type: 'circle',
                    content: '练习内容', description: 'Event 1'
                }
            ],
            lineData: [],
            formInline: {
                id: "",
                token: localStorage.getItem('logintoken')
            },
        }
    },
    created() {
        this.getdata(this.formInline)
    },
    methods: {
        getdata(parameter) {
            PersonEventView(parameter)
                .then(res => {
                    this.loading = false
                    if (res.success == false) {
                        this.$message({
                            type: 'info',
                            message: res.msg
                        })
                    } else {
                        this.lineData = []
                        res.data.forEach(item => {
                            this.lineData.push({
                                tag: item.eventDate,
                                content: item.typeName
                            });
                        });
                    }
                })
                .catch(err => {
                    this.$message.error('菜单加载失败，请稍后再试！')
                })

        },
        // 搜索事件
        search() {
            this.getdata(this.formInline)
        }
    }
};
</script>
  
<style>
/* 根据需求自定义样式 */
</style>
  