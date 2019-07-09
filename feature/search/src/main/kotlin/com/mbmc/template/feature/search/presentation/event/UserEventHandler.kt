package com.mbmc.template.feature.search.presentation.event

interface UserEventHandler {
    fun onClicked()
    fun onRetryClicked()
    fun onTextChanged(charSequence: CharSequence)
}
