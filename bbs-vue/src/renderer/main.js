// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import polyfill from 'babel-polyfill'
import App from './App'
import axios from 'axios'
// import 'lib-flexible/flexible.js'
import store from './store'

import filters from './filters' //将全部过滤器放在 filters/index.js 中便于管理
import router from './router'
import ElementUI from 'element-ui'
import request from './utils/request'

import 'element-ui/lib/theme-chalk/index.css'


// permission control todo
// import './permission'

if (process.env.NODE_ENV === 'development') Vue.config.devtools = true

filters(Vue)


Vue.use(polyfill)

Vue.use(ElementUI)

Vue.prototype.$http = request.axiosIntercept(Vue)



// vue全局异常
Vue.config.errorHandler = function (err, vm, info) {
    // handle error
    // `info` 是 Vue 特定的错误信息，比如错误所在的生命周期钩子
    // console.error('vue golbal error', err, vm, info)
}

 



Vue.config.productionTip = false

var _this = new Vue({
    el: '#app',
    store,
    router,
    components: {
        App
    },
    template: '<App/>'
})

