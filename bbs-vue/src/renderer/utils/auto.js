import Cookies from 'js-cookie'

const tokenKey = 'token'
const infoKey = 'newbeeInfo'

export function setToken(token) {
    return Cookies.set(tokenKey, token)
}

export function setInfo(token) {
    return Cookies.set(infoKey, token)
}

export function getToken() {
    return Cookies.get(tokenKey)
}

export function getUserName() {
    console.log(getInfo())
    return JSON.parse(getInfo()).userName
}

export function getInfo() {
    return Cookies.get(infoKey)
}

export function removeToken(token) {
    Cookies.remove(tokenKey)
}