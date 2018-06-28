import Vue from 'vue'
import Router from 'vue-router'

// 错误页面
// const Page401 = () =>
//     import( /* webpackChunkName:page401 */ '@/container/errpage/Page401')
// const Page404 = () =>
//     import( /* webpackChunkName:page404 */ '@/container/errpage/Page404')

import Index from '@/container/index'

import Login from '@/container/login/Login'


Vue.use(Router)

let route = [
    // { path: '/404', component: Page404 },
    // { path: '/401', component: Page401 },
    {
        path: '/',
        name: 'Index',
        component: Index
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    }
]

// 加载路由模块


export default new Router({
    routes: route,

})
