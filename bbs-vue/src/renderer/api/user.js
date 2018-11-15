import request from '@/utils/request'

let Api = Function();
let axios = request.axiosIntercept();
/**
 * 私有
 */
Api.prototype = {
    getUserInfoByUserName(userName, fn) {
        axios.get("/user/getUserInfo/" + userName).then(res => {
            if (res.data.code === 200) {
                //   this.userInfo = res.data.data;
                fn(res.data)
            }
        });
    },
    login(params, fn) {
        axios.post("/user/login", params)
            .then(res => {
                if (res.data.code === 200) {
                    fn(res.data)
                }
                //   debugger;
            });
    },
    register(params, fn) {
        axios.post("/user/register", params, {
            headers: {
                Accept: "application/json;charset=UTF-8"
            }
        })
            .then(res => {
                if (res.data.code === 200) {
                    fn(res.data)
                }
            });
    },
    saveUser(params, fn) {
        axios.post("/user/saveUser", params).then(res => {
            if (res.data.code === 200) {
                fn(res.data)
            }
        });
    }
}
export default new Api()