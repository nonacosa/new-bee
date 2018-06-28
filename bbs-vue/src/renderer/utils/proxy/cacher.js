export class Cacher {

    constructor(option) {
        this.cacheMap = new Map()
        this.option = option || {}
        this.maxCacheSize = this.option.maxCacheSize || 15
        this.ttl = this.option.ttl
        this.filters = []
        this.excludeHeaders = this.option.excludeHeaders || true
    }

    /**
     * [addFilter 添加匹配规则]
     * @param {[reg]} reg
     */
    addFilter(reg) {
        this.filters.push(reg)
    }

    /**
     * [removeFilter 移除匹配规则]
     * @param  {[reg]} reg
     */
    removeFilter(reg) {
        let index = this.filters.indexOf(reg)
        if(index !== -1) {
            this.filters.splice(index, 1)
        }
    }

    /**
     * [setCache 添加缓存]
     * @param {[any]} opt
     * @param {[any]} value
     */
    setCache(opt, value) {
        /*只取params和url做key*/
        // if(this.excludeHeaders) delete key.headers
        let key='';
        if(typeof opt.url !=='undefined'){
            key+=opt.url;
        }

        if(typeof opt.params !=='undefined'){
            key+=JSON.stringify(opt.params);
        }

        this.cacheMap.set(key, value)
        if(this.maxCacheSize && this.cacheMap.size > this.maxCacheSize) {
            this.cacheMap.delete([...(this.cacheMap).keys()][0])
        }

        /*if(this.ttl) {
            setTimeout(() => {
                if(this.hasCache(opt)) {
                    this.cacheMap.delete(JSON.stringify(opt))
                }
            }, this.ttl)
        }*/
    }

    /**
     * [needCache 检查是否命中匹配规则]
     * @param  {[obj]} option
     * @return {[boolean]}
     */
    needCache(option) {
        return this.filters.some(reg => {
            return reg.test(option.url)
        })
    }

    /**
     * [hasCache 是否已有缓存]
     * @param  {[any]}  key
     * @return {Boolean}
     */
    hasCache(key) {
        return this.cacheMap.has(key)
    }

    /**
     * [getCache 获取缓存内容]
     * @param  {[any]} key
     * @return {[any]}
     */
    getCache(key) {
        return this.cacheMap.get(key)
    }

    /**
     * [clear 清空缓存]
     */
    clear() {
        this.cacheMap.clear()
    }

    getKey(url,params) {
        return url+JSON.stringify(params);
    }

}
