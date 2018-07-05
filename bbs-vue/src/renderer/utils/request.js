import axios from 'axios'

const BASE_API = ""

export function axiosIntercept(Vue, router) {
    const axiosIntercept = axios.create({
        baseURL: BASE_API
    })
    axios.interceptors.request.use(
        (config) => {
            // 判断是否存在token，如果存在的话，则每个http header都加上token
            // if (store.getters.accessToken) {
            //     console.log(store.getters.accessToken)
            //     config.headers.Authorization = `token ${store.getters.accessToken}`;
            // }
            //根据接口传入参数显示加载动画
            // showFullScreenLoading();

            //解决axios post请求后台获取不到参数问题
            if (config.method === 'post') {

            };

            return config;
        }, function (err) {
            return Promise.reject(err);
        });


    //http response 拦截器
    axiosIntercept.interceptors.response.use(function (response) {
        //暂停加载动画
        // tryHideFullScreenLoading();
        return response;
    }, function (err) {
        if (err.response) {
            switch (err.response.status) {
                case 401:
                    // 返回 401 清除token信息并跳转到登录页面
                    store.dispatch("logout");
                    router.replace({
                        path: 'Login',
                        query: { redirect: router.history.current.fullPath }
                    })
            }
        }
        return Promise.reject(err);
    });
    return axiosIntercept;
}

