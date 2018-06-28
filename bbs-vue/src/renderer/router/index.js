import Vue from 'vue'
import Router from 'vue-router'

// 错误页面
// const Page401 = () =>
//     import( /* webpackChunkName:page401 */ '@/container/errpage/Page401')
// const Page404 = () =>
//     import( /* webpackChunkName:page404 */ '@/container/errpage/Page404')

import Login from '@/container/login/Login'

console.log(Login)

Vue.use(Router)

let route = [
    // { path: '/404', component: Page404 },
    // { path: '/401', component: Page401 },
    {
        path: '/Login',
        name: 'Login',
        component: Login
    },
    {
        path: '/1',
        name: '1',
        component: Login
    }
]

console.log(route)
console.log(new Router({
    routes: route,

}))
// 加载路由模块


export default new Router({
    routes: route,

})
