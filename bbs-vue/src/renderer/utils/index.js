
import _ from 'lodash'

export function goBack(vue) {
    vue.$router.go(-1)
}
export function sampleBackGroundColor() {
    let color_arr = [
        "is-orange",
        "is-bootstrap",
        "is-primary",
        "is-success",
        "is-info",
        "is-danger"
    ]
    return _.sample(color_arr)
}