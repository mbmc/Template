package com.mbmc.template.common.core.session

class SessionManager(val token: String) {
    fun isLoggedIn(): Boolean {
        return false // token.isEmpty()
    }
}
