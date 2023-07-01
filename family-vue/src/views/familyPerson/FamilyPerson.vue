
<template>
  <div>
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>家族管理</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 搜索筛选 -->
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="搜索：">
        <el-input size="small" v-model="formInline.id" placeholder="输入成员id"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()">添加</el-button>
      </el-form-item>
    </el-form>
    <!--列表-->
    <el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中"
      style="width: 100%;">
            </el-table-column>
                  <el-table-column sortable prop="id" label="成员id" width="120" show-overflow-tooltip>
                      </el-table-column>
                  <el-table-column sortable prop="avatar" label="头像" width="180" show-overflow-tooltip>
        <template slot-scope="scope">
          <img :src="scope.row.avatar" width="50" height="50">
        </template>
                      </el-table-column>
                  <el-table-column sortable prop="familyId" label="家族id" width="120" show-overflow-tooltip>
                      </el-table-column>
                  <el-table-column sortable prop="name" label="姓名" width="120" show-overflow-tooltip>
                      </el-table-column>
                  <el-table-column sortable prop="sex" label="性别" width="140" show-overflow-tooltip>
                      </el-table-column>
                  <el-table-column sortable prop="birthDate" label="出生日期" width="120" show-overflow-tooltip>
                      </el-table-column>
                  <el-table-column sortable prop="deathDate" label="死亡日期" width="120" show-overflow-tooltip>
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
        <el-form-item label="成员id" prop="id" v-if="false">
          <el-input size="small" v-model="editForm.id" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="头像" prop="avatar">
          <el-input size="small" v-model="editForm.avatar" auto-complete="off" v-if="false"></el-input>
          <el-upload ref="uploadRef" action="http://localhost:9999/upload" :auto-upload="true" :show-file-list="false"
            :on-success="handleAvatarUploadSuccess">
            <el-button v-show="!editForm.avatar" size="small" type="primary">点击上传</el-button>
          </el-upload>
          <span @click="launchUpload" style="cursor: pointer;">
            <img v-if="editForm.avatar" :src="editForm.avatar" alt="头像" width="50" height="50" />
          </span>
        </el-form-item>

        <el-form-item label="家族id" prop="familyDesc">
          <el-input size="small" v-model="editForm.familyId" auto-complete="off" placeholder="请输入家族id"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input size="small" v-model="editForm.name" auto-complete="off" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select size="small" v-model="editForm.sex" placeholder="请选择性别">
            <el-option value="M" label="男"></el-option>
            <el-option value="F" label="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthDate">
          <el-date-picker size="small" v-model="editForm.birthDate" type="date" format="yyyy-MM-dd"
            placeholder="请选择出生日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="死亡日期" prop="deathDate">
          <el-date-picker size="small" v-model="editForm.deathDate" type="date" format="yyyy-MM-dd"
            placeholder="请选择死亡日期"></el-date-picker>
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
import { FamilyPersonList } from '../../api/basisMG'
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
        avatar: '',
        familyId: '',
        name: '',
        sex: '',
        birthDate: '',
        deathDate: '',
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
      }
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
      FamilyPersonList(parameter)
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
          this.$message.error('列表加载失败，请稍后再试！')
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
      this.editFormVisible = true
      if (row != undefined && row != 'undefined') {
        console.log(row)
        this.title = '修改'
        this.editForm.id = row.id
        this.editForm.avatar = row.avatar
        this.editForm.familyId = row.familyId
        this.editForm.name = row.name
        this.editForm.sex = row.sex
        this.editForm.birthDate = row.birthDate
        this.editForm.deathDate = row.deathDate
      } else {
        this.title = '添加'
        this.editForm.id = ""
        this.editForm.avatar = ""
        this.editForm.familyId = ""
        this.editForm.name = ""
        this.editForm.sex = ""
        this.editForm.birthDate = ""
        this.editForm.deathDate = ""
      }
    },
    // 编辑、增加页面保存方法
    submitForm(editData) {
      this.$refs[editData].validate(valid => {
        if (valid) {
          // 发送POST请求给后端
          fetch('http://localhost:9999/submitOrUpdateFamilyPerson', {
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
          fetch('http://localhost:9999/delFamilyPerson', {
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
    handleAvatarUploadSuccess(response) {
      console.log(response);
      if (response) {
        this.editForm.avatar = response.data; // 更新editForm.avatar属性为上传图片的URL
        this.$forceUpdate();
      }
    }, launchUpload() {
      const uploadButton = this.$refs.uploadRef.$el.querySelector('.el-upload__input');
      uploadButton.click();

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

 
 