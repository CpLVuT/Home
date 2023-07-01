
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
        <el-input size="small" v-model="formInline.id" placeholder="输入家族id"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()">添加</el-button>
      </el-form-item>
    </el-form>
    <!--列表-->
    <el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中"
      style="width: 100%;">
      <el-table-column align="center" type="selection" width="60">
      </el-table-column>
      <el-table-column sortable prop="id" label="家族id" width="300">
      </el-table-column>
      <el-table-column sortable prop="userId" label="用户id" width="300">
      </el-table-column>
      <el-table-column sortable prop="familyDesc" label="说明" width="300">
      </el-table-column>
      <el-table-column sortable prop="createTime" label="创建时间" width="300">
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
        <el-form-item label="家族id" prop="id" v-if="false">
          <el-input size="small" v-model="editForm.id" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="家族说明" prop="familyDesc">
          <el-input size="small" v-model="editForm.familyDesc" auto-complete="off" placeholder="请输入家族说明"></el-input>
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
import {FamilyList} from '../../api/basisMG'
import Pagination from '../../components/Pagination'
export default {
  data() {
    return {
      nshow: true, //switch开启
      fshow: false, //switch关闭
      loading: false, //是显示加载
      editFormVisible: false, //控制编辑页面显示与隐藏
      /*
      上面部分不是很重要。
       */
      title: '添加',
      /*
      表单数据对象信息 token的含义不再强调。
       */
      editForm: {
        id: '',
        userId: '',
        familyDesc: '',
        createTime: '',
        token: localStorage.getItem('logintoken')
      },
      // rules表单验证是否为空 如果为空就弹出来。也不是很重要。
      rules: {
        deptName: [
          { required: true, message: '请输入部门名称', trigger: 'blur' }
        ]
      },
      /*
      分页相关 一页十个 锦上添花罢了。
       */
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
      /*
      我们声明过的代码 还记得吗在basisMG里。
       */
      FamilyList(parameter)
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
        /*
        如果商户没能获取到家族数据的话 就在这里弹出失败。
         */
        .catch(err => {
          this.loading = false
          this.$message.error('菜单加载失败，请稍后再试！')
        })

    },
    // 分页插件事件 这一部分是抄的。为了锦上添花乱写的
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
        this.title = '修改'
        this.editForm.id = row.id
        this.editForm.familyDesc = row.familyDesc
        console.log(row)
      } else {
        this.title = '添加'
        this.editForm.id = null
        this.editForm.familyDesc = row.familyDesc
      }
    },
    // 编辑、增加页面保存方法
    submitForm(editData) {
      this.$refs[editData].validate(valid => {
        /*
        验证表单是否合乎规定
         */
        if (valid) {
          // 发送POST请求给后端
          fetch('http://localhost:9999/submitOrUpdateFamily', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(this.editForm),
          })
            /*
            判断回传的json（response result的返回值）
             */
            .then(response => response.json())
            .then(data => {
              this.editFormVisible = false
              this.loading = false
              /*
              code10000是我重写后端的多次使用的成功代码标记。
               */
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
            body: new URLSearchParams({id:row.id}),
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


