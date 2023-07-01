// 导入组件
import Vue from 'vue';
import Router from 'vue-router';
// 登录
import login from '@/views/login';
// 首页
import index from '@/views/index';
/**
 * 基础菜单
 */
// 家族管理
import Family from '@/views/family/Family';
//家族成员管理
import FamilyPerson from '@/views/familyPerson/FamilyPerson'
//人员关系管理
import PersonRelation from '@/views/personRelation/PersonRelation'
//成员关系可视化
import PersonRelationView from '@/views/personRelation/PersonRelationView'
//成员履历管理
import PersonEvent from '@/views/PersonEvent/PersonEvent'
//成员履历可视化
import PersonEventView from '@/views/PersonEvent/PersonEventView'




// 启用路由
Vue.use(Router);

// 导出路由 
export default new Router({
    routes: [{
        path: '/',
        name: '',
        component: login,
        hidden: true,
        meta: {
            requireAuth: false
        }
    }, {
        path: '/login',
        name: '登录',
        component: login,
        hidden: true,
        meta: {
            requireAuth: false
        }
    }, {
        path: '/index',
        name: '首页',
        component: index,
        iconCls: 'el-icon-tickets',
        children: [{
            path: '/family/Family',
            name: '家族管理',
            component: Family,
            meta: {
                requireAuth: true
            }
        }, {
            path: '/familyPerson/FamilyPerson',
            name: '家族成员管理',
            component: FamilyPerson,
            meta: {
                requireAuth: true
            }
        },{
            path: '/personRelation/PersonRelation',
            name: '成员关系管理',
            component: PersonRelation,
            meta: {
                requireAuth: true
            }
        },{
            path: '/personRelation/PersonRelationView',
            name: '成员关系可视化',
            component: PersonRelationView,
            meta: {
                requireAuth: true
            }
        },{
            path: '/personEvent/PersonEvent',
            name: '成员履历管理',
            component: PersonEvent,
            meta: {
                requireAuth: true
            } 
        }
        ,{
            path: '/personEventView/PersonEventView',
            name: '成员履历可视化',
            component: PersonEventView,
            meta: {
                requireAuth: true
            } 
        }
    ]
    }]
})