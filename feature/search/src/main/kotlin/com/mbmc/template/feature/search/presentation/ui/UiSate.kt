package com.mbmc.template.feature.search.presentation.ui

import androidx.databinding.ObservableBoolean

class UiSate {
    val hasText = ObservableBoolean()
    val hasError = ObservableBoolean()
    val isLoading = ObservableBoolean()

    fun setHasText(hasText: Boolean) {
        this.hasText.set(hasText)
    }

    fun setHasError() {
        hasError.set(true)
    }

    fun setIsLoading() {
        isLoading.set(true)
    }

    fun setIsIdle() {
        hasError.set(false)
        isLoading.set(false)
    }
}
