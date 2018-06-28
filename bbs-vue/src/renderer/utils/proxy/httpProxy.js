import {Cacher} from './cacher'
import { isMhApp } from '../fn'
/**
 * [wrapper 包装器]
 * @param  {[axios instance]} instance
 * @param  {[obj]} option
 * @return {[axios instance with cache feature]}
 *
 */

export default function wrapper(instance, option) {

    PSMU.debug("httpProxy init ")

    const cacher = new Cacher(option)

    const unCacheMethods = [
        'delete',
        'head',
        'options',
        'put',
        'patch'
    ]
    /**
     * callback缓存
     * 使用原生http请求需要传callback 不能用then方式
     * callback非全局，只在当前页面有效，切换路由等操作会导致原生回调失败（特殊需要可以扩展）。页面切换之前请求可以抛弃了
     * */
    let cbCache={}

    let cbCount=0;

    /**
     * [axiosWithCache axios instance Proxy]
     * @param  {...[any]} arg
     * @return {[promise]}
     * 【注意】按url和params缓存数据 data不会被考虑
     * 使用原生http请求需要传callback 不能用then方式
     * callback非全局，只在当前页面有效，切换路由等操作会导致原生回调失败（特殊需要可以扩展）。页面切换之前请求可以抛弃了
     */
    function axiosWithCache(...arg) {
        if(arg.length >= 1 ){
            if(arg[0].isCache === true ){
                if((arg[0].method === 'get' || arg[0].method === undefined)) {
                    return axiosWithCache.get(...arg)
                    // return requestWithCacheCheck(arg[0], instance, ...arg)
                }else if(arg[0].method === 'post'){
                    /*正常情况是不需要post的，因为无法用很大的data做key，支持post只为一些通过post取数据的场景*/

                }
            }
        }
        return instance(...arg)
    }

    /**
     * [requestWithCacheCheck 对于 get 请求检查缓存，返回结果 promise]
     * @param  {[obj]}    option
     * @param  {[request handler func]}    instance
     * @param  {...[any]} arg
     * @return {[promise]}
     */
    /*function requestWithCacheCheck(option, instance, ...arg) {
        if(cacher.hasCache(option)) {
            return Promise.resolve({
                __fromAxiosCache: true,
                ...cacher.getCache(option)
            })
        }else {
            if(arg.length > 1 && typeof arg[1] === 'function'){
                /!*调原生*!/
                let cbId="callback"+cbCount;
                cbCache[cbId]=arg[1];
                if (String(MHAppapi.isNetOk()) !== 'true') {

                }
            }else{
                return instance(...arg).then(response => {
                    cacher.setCache(option, response)
                    return response
                })
            }
        }
    }*/

    /**
     * @param  url,params,callback
     * params.isCache 控制是否使用本地缓存
     * @return {[promise]}
     *
     * 返回值通过callback异步回传，目前不支持同步有必要可以扩展
     * get(url,{ isCache:true,params: {aaa:'',companyId:that.companyId}},callback)
     */
    axiosWithCache.get = function(...arg) {

        // PSMU.debug(isMhApp()+" httpProxy get "+arg.length,arg)
        PSMU.debug(`httpProxy get: isMhApp - ${isMhApp()}, args - ${arg.length}`, arg)

        let that=this;
        if(arg.length === 1) {
            return instance.get(...arg);
        }else if(isMhApp() && arg.length >= 2) {
            /*android ios exe 调用本地缓存 */
            if(typeof arg[1] ==='object' && arg[1].isCache === true ){
                let url=arg[0];
                let opt=arg[1];
                let key=cacher.getKey(url,opt.params);

                if(arg.length > 2 && typeof arg[2] === 'function'){
                    let callback=arg[2];
                    /*调原生http请求*/
                    let cbId="callback"+cbCount++;
                    cbCache[cbId]=callback;
                    MHAppJSBridge.regAxiosCB(cbId,that);
                    PSMU.debug("isMhApp get ",MHAppapi,typeof(MHAppapi.get))
                    MHAppapi.get(url,PSMU.stringify(opt.params),cbId,"MHAppJSBridge.onAxiosCB","");
                    return true;
                }

                /*else{
                    /!*调原始本地存储*!/
                    return instance.get(...arg).then(response => {
                        cacher.setCache(key, response)
                        return response
                    })
                }*/
                /*if(cacher.hasCache(key)) {
                    return Promise.resolve({
                        __fromAxiosCache: true,
                        ...cacher.getCache(key)
                    })
                }else {

                }*/
            }
        }
        if(arg.length > 2 && typeof arg[2] === 'function'){
            instance.get(...arg).then(function(res) {arg[2](res)});
        }else{
            return instance.get(...arg)
        }

    }

    /**
     * [__addFilter cacher instance addFilter function proxy]
     * @param  {[reg]} filter
     */
    axiosWithCache.__addFilter = function(filter) {
        cacher.addFilter(filter)
    }

    /**
     * [__removeFilter cacher instance removeFilter function proxy]
     * @param  {[reg]} filter
     */
    axiosWithCache.__removeFilter = function(filter) {
        cacher.removeFilter(filter)
    }

    /**
     * [cacher instance proxy]
     */
    axiosWithCache.__cacher = cacher

    /**
     * [__clearCache cacher instance clear function proxy]
     */
    axiosWithCache.__clearCache = function(){
        cacher.clear()
    }

    /**
     * [proxy axios instance functions which are no need to be cached]
     */
    unCacheMethods.forEach(method => {
        axiosWithCache[method] = function(...arg) {
            return instance[method](...arg)
        }
    })

    return axiosWithCache
}
