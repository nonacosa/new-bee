import axios from 'axios'
import * as types from '../mutation-types'

let state = {
    userInfo: null,

}


//  getters
const getters = {

}


//  actions

const actions = {


}

//  mutations

const mutations = {
    [types.SET_USER_INFO](state, bool) {
        state.isMode = bool
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}
