import Vue from 'vue'
import Router from 'vue-router'

// 错误页面
// const Page401 = () =>
//     import( /* webpackChunkName:page401 */ '@/container/errpage/Page401')
// const Page404 = () =>
//     import( /* webpackChunkName:page404 */ '@/container/errpage/Page404')

const Index = () => import(/* webpackChunkName: "index" */ '@/container/index')
const LoginIndex = () => import(/* webpackChunkName: "login" */ '@/container/login/Index')
const Login = () => import(/* webpackChunkName: "login" */ '@/container/login/Login')
const Register = () => import(/* webpackChunkName: "login" */ '@/container/login/Register')
const Blog = () => import(/* webpackChunkName: "blog" */ '@/container/blog/Blog')
const EditBlog = () => import(/* webpackChunkName: "blog" */ '@/container/blog/EditBlog')
const User = () => import(/* webpackChunkName: "user" */ '@/container/user/User')
const Setting = () => import(/* webpackChunkName: "user" */ '@/container/user/Setting')
const Life = () => import(/* webpackChunkName: "life" */ '@/container/life/Life')
const Book = () => import(/* webpackChunkName: "book" */ '@/container/book/Book')


Vue.use(Router)

let route = [
    // { path: '/404', component: Page404 },
    // { path: '/401', component: Page401 },
    {
        path: '/',
        name: 'index',
        component: Index
    },
    {
        path: '/login',
        component: LoginIndex,
        children: [{
            path: '',
            redirect: 'index'
        }, {
            path: 'index',
            name: 'login',
            component: Login
        }, {
            path: 'register',
            name: 'register',
            component: Register
        }]

    },
    {
        path: '/blog/:id',
        name: 'blog',
        component: Blog,

    },
    {
        path: '/life',
        name: 'life',
        component: Life,

    },
    {
        path: '/editor/post/new',
        name: '发文章',
        component: EditBlog,

    },
    {
        path: '/editor/edit/:id',
        name: '编辑文章',
        component: EditBlog,

    },

    {
        path: '/book',
        name: 'book',
        component: Book
    },
    {
        path: '/user/:userName',
        name: '用户页',
        component: User
    },
    {
        path: '/setting/:userName',
        name: 'Setting',
        component: Setting
    }
]

// 加载路由模块


export default new Router({
    routes: route,

})
