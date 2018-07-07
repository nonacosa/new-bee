import Cookies from 'js-cookie'

const tokenKey = 'token'

export function setToken(token) {
    return Cookies.set(tokenKey, token)
}

export function getToken(token) {
    return Cookies.get(tokenKey)
}

export function removeToken(token) {
    Cookies.remove(tokenKey)
}