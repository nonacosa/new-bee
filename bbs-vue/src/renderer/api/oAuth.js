import axios from 'axios'

let Api = Function()

Api.prototype = {
    getUser(code, fn) {
        axios.get(`/github/getUser/${code}`).then(res => {
            // if (res.data.code === 200) {
            fn(res.data)
            // }
        }).error()

    }
}
export default new Api()


