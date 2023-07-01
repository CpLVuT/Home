import axios from 'axios';
import { req } from './axiosFun';



//家族列表
export const FamilyList = (params) => { return req("post","/familyList",params)};

//家族成员列表
export const FamilyPersonList = (params) => { return req("post","/familyPersonList",params)};
//家族成员列表 不分页
export const FamilyPersonListAll  = (params) => { return req("post","/familyPersonListAll",params)};

//成员关系列表
export const PersonRelationList = (params) => { return req("post","/personRelationList",params)}

//成员关系可视化
export const PersonRelationHierarchyList = (params) => { return req("post","/getHierarchyList",params)}


//关系类型列表
export const PersonTypeList = (params) => { return req("post","/personTypeList",params)}
//关系类型列表 不分页
export const PersonTypeListAll = (params) => { return req("post","/personTypeListAll",params)}

//成员事件列表
export const PersonEventList = (params) => { return req("post","/personEventList",params)}
//成员事件可视化
export const PersonEventView = (params) => { return req("post","/personEventView",params)}

//事件类型 不分页 查
export const EventTypeListAll = (params) => { return req("post","/eventTypeListAll",params)}
