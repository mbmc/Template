package com.mbmc.template.core.session

class SessionManager(val token: String) {
    fun isLoggedIn(): Boolean {
        return false // token.isEmpty()
    }
}
