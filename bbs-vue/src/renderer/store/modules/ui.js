import axios from 'axios'
import * as types from '../mutation-types'

let state = {
    isMode: false,

}


//  getters
const getters = {



}


//  actions

const actions = {



}

//  mutations

const mutations = {
    [types.SET_MODE](state, bool) {
        state.isMode = bool
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}
