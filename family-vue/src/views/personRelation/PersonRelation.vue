
<template>
    <div>
        <!-- 面包屑导航 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>成员关系管理</el-breadcrumb-item>
        </el-breadcrumb>
        <!-- 搜索筛选 -->
        <el-form :inline="true" :model="formInline" class="user-search">
            <el-form-item label="搜索：">
                <el-input size="small" v-model="formInline.id" placeholder="输入关系id"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
                <el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()">添加</el-button>
            </el-form-item>
        </el-form>
        <!--列表-->
        <el-table size="small" :data="listData" highlight-current-row v-loading="loading" border
            element-loading-text="拼命加载中" style="width: 100%;">
            <el-table-column align="center" type="selection" width="60">
            </el-table-column>
            <el-table-column sortable prop="id" label="关系id" width="300">
            </el-table-column>
            <el-table-column sortable prop="personName1" label="成员1" width="300">
            </el-table-column>
            <el-table-column sortable prop="personName2" label="成员2" width="300">
            </el-table-column>
            <el-table-column sortable prop="personTypeName" label="成员关系" width="300">
            </el-table-column>
            <el-table-column align="center" label="操作" min-width="300">
                <template slot-scope="scope">
                    <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button size="mini" type="danger" @click="deleteUser(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 分页组件 -->
        <Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
        <!-- 编辑界面 -->
        <el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
            <el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
                <el-form-item label="关系id" prop="id" v-if="false">
                    <el-input size="small" v-model="editForm.id" auto-complete="off"></el-input>
                </el-form-item>

                <el-form-item label="成员id1" prop="personId1">
                    <el-select v-model="editForm.personId1" size="small" placeholder="请选择成员1" @change="$forceUpdate()">
                        <el-option v-for="item in FamilyPersonList" :key="item.id" :label="item.name"
                            :value="item.id"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="成员id2" prop="personId2">
                    <el-select v-model="editForm.personId2" size="small" placeholder="请选择成员2" @change="$forceUpdate()">
                        <el-option v-for="item in FamilyPersonList" :key="item.id" :label="item.name"
                            :value="item.id"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="关系id" prop="personTypeId">
                    <el-select v-model="editForm.personTypeId" size="small" placeholder="请选择关系" @change="$forceUpdate()">
                        <el-option v-for="item in PersonRelationList" :key="item.id" :label="item.name"
                            :value="item.id"></el-option>
                    </el-select>
                </el-form-item>

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button size="small" @click="closeDialog">取消</el-button>
                <el-button size="small" type="primary" :loading="loading" class="title"
                    @click="submitForm('editForm')">保存</el-button>
            </div>
        </el-dialog>
    </div>
</template>
  
<script>
import { PersonRelationList, FamilyPersonListAll, PersonTypeListAll } from '../../api/basisMG'
import Pagination from '../../components/Pagination'
export default {
    data() {
        return {
            nshow: true, //switch开启
            fshow: false, //switch关闭
            loading: false, //是显示加载
            editFormVisible: false, //控制编辑页面显示与隐藏
            title: '添加',
            editForm: {
                id: '',
                userId: '',
                familyDesc: '',
                createTime: '',
                token: localStorage.getItem('logintoken')
            },
            // rules表单验证
            rules: {
                deptName: [
                    { required: true, message: '请输入部门名称', trigger: 'blur' }
                ]
            },
            formInline: {
                page: 1,
                limit: 10,
                varLable: '',
                varName: '',
                token: localStorage.getItem('logintoken')
            },
            // 删除
            seletedata: {
                ids: '',
                token: localStorage.getItem('logintoken')
            },
            userparm: [], //搜索权限
            listData: [], //用户数据
            // 分页参数
            pageparm: {
                currentPage: 1,
                pageSize: 10,
                total: 10
            },
            FamilyPersonList: [],  // 成员列表数据
            PersonRelationList: [],  // 关系列表数据
        }
    },
    // 注册组件
    components: {
        Pagination
    },
    /**
     * 数据发生改变
     */

    /**
     * 创建完毕
     */
    created() {
        this.getdata(this.formInline)
    },


    /**
     * 里面的方法只有被调用才会执行
     */
    methods: {
        // 获取列表
        getdata(parameter) {
            console.log(parameter);
            this.loading = true
            PersonRelationList(parameter)
                .then(res => {
                    this.loading = false
                    if (res.success == false) {
                        this.$message({
                            type: 'info',
                            message: res.msg
                        })
                    } else {
                        this.listData = res.data.records
                        // 分页赋值
                        this.pageparm.currentPage = res.data.current
                        this.pageparm.pageSize = res.data.size
                        this.pageparm.total = res.data.total
                    }
                })
                .catch(err => {
                    this.loading = false
                    this.$message.error('菜单加载失败，请稍后再试！')
                })

        },
        // 分页插件事件
        callFather(parm) {
            this.formInline.page = parm.currentPage
            this.formInline.limit = parm.pageSize
            this.getdata(this.formInline)
        },
        // 搜索事件
        search() {
            this.getdata(this.formInline)
        },
        //显示编辑界面
        handleEdit: function (index, row) {
            this.fetchMemberList()
            this.fetchRelationList()
            this.editFormVisible = true
            if (row != undefined && row != 'undefined') {
                this.title = '修改'
                this.editForm.id = row.id
                this.editForm.personId1 = row.personId1
                this.editForm.personId2 = row.personId2
                this.editForm.personTypeId = row.personTypeId
            } else {
                this.title = '添加'
                this.editForm.id = null
                this.editForm.personId1 = null
                this.editForm.personId2 = null
                this.editForm.personTypeId = null
            }
        },
        // 编辑、增加页面保存方法
        submitForm(editData) {
            this.$refs[editData].validate(valid => {
                if (valid) {
                    // 发送POST请求给后端
                    fetch('http://localhost:9999/submitOrUpdatePersonRelation', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify(this.editForm),
                    })
                        .then(response => response.json())
                        .then(data => {
                            this.editFormVisible = false
                            this.loading = false
                            if (data.code == 10000) {
                                this.$message({
                                    type: 'success',
                                    message: '操作成功！'
                                })
                                this.getdata(this.formInline)
                            }
                        })
                        .catch(error => {
                            this.$message({
                                type: 'error',
                                message: '操作失败！'
                            })
                        });
                } else {
                    return false
                }
            })
        },
        // 删除
        deleteUser(index, row) {
            this.$confirm('确定要删除吗?', '信息', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            })
                .then(() => {
                    // 发送POST请求给后端
                    fetch('http://localhost:9999/delFamily', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded',
                        },
                        body: new URLSearchParams({ id: row.id }),
                    })
                        .then(response => response.json())
                        .then(data => {
                            this.editFormVisible = false
                            this.loading = false
                            if (data.code == 10000) {
                                this.$message({
                                    type: 'success',
                                    message: '操作成功！'
                                })
                                this.getdata(this.formInline)
                            }
                        })
                        .catch(error => {
                            this.$message({
                                type: 'error',
                                message: '操作失败！'
                            })
                        });
                })
                .catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    })
                })
        },
        // 关闭编辑、增加弹出框
        closeDialog() {
            this.editFormVisible = false
        },
        fetchMemberList() {
            FamilyPersonListAll(null)
                .then(res => {
                    this.loading = false
                    if (res.success == false) {
                        this.$message({
                            type: 'info',
                            message: res.msg
                        })
                    } else {
                        this.FamilyPersonList = res.data
                        console.log(this.FamilyPersonList)
                    }
                })
                .catch(err => {
                    this.loading = false
                    this.$message.error('菜单加载失败，请稍后再试！')
                })
        },
        fetchRelationList() {
            PersonTypeListAll(null)
                .then(res => {
                    this.loading = false
                    if (res.success == false) {
                        this.$message({
                            type: 'info',
                            message: res.msg
                        })
                    } else {
                        this.PersonRelationList = res.data
                    }
                })
                .catch(err => {
                    this.loading = false
                    this.$message.error('菜单加载失败，请稍后再试！')
                })
        }
    }
}
</script>
  
<style scoped>
.user-search {
    margin-top: 20px;
}

.userRole {
    width: 100%;
}
</style>
  
   
   