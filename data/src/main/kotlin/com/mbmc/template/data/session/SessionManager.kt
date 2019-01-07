package com.mbmc.template.data.session

class SessionManager(val token: String) {
    fun isLoggedIn(): Boolean {
        return false // token.isEmpty()
    }
}
