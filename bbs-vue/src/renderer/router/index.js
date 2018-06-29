import Vue from 'vue'
import Router from 'vue-router'

// 错误页面
// const Page401 = () =>
//     import( /* webpackChunkName:page401 */ '@/container/errpage/Page401')
// const Page404 = () =>
//     import( /* webpackChunkName:page404 */ '@/container/errpage/Page404')

import Index from '@/container/index'
import LoginIndex from '@/container/login/Index'
import Login from '@/container/login/Login'
import Register from '@/container/login/Register'
import Blog from '@/container/blog/Blog'
import EditBlog from '@/container/blog/EditBlog'
import User from '@/container/user/User'
import Book from '@/container/book/Book'


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
        component: LoginIndex,
        children: [{
            path: '',
            redirect: 'login'
        }, {
            path: 'login',
            name: 'login',
            component: Login
        }, {
            path: 'register',
            name: 'register',
            component: Register
        }]

    },
    {
        path: '/blog',
        name: 'blog',
        component: Blog,

    },
    {
        path: '/blog/edit',
        name: 'editBlog',
        component: EditBlog,

    },
    {
        path: '/book',
        name: 'book',
        component: Book
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
