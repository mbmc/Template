package com.mbmc.template.event

interface UserEventHandler {
    fun onClicked()
    fun onRetryClicked()
    fun onTextChanged(charSequence: CharSequence)
}
