import Vue from 'vue'
import Router from 'vue-router'

// 错误页面
// const Page401 = () =>
//     import( /* webpackChunkName:page401 */ '@/container/errpage/Page401')
// const Page404 = () =>
//     import( /* webpackChunkName:page404 */ '@/container/errpage/Page404')

import Index from '@/container/index'
import Login from '@/container/login/Login'
import Blog from '@/container/blog/Blog'
import User from '@/container/user/User'


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
    },
    {
        path: '/blog',
        name: 'blog',
        component: Blog
    },
    {
        path: '/user',
        name: 'user',
        component: User
    }
]

// 加载路由模块


export default new Router({
    routes: route,

})
