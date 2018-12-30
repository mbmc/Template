package com.mbmc.template.ui;

import androidx.databinding.ObservableBoolean;

public class UiSate {

    public final ObservableBoolean hasText = new ObservableBoolean();
    public final ObservableBoolean hasError = new ObservableBoolean();
    public final ObservableBoolean isLoading = new ObservableBoolean();

    public void setHasText(boolean hasText) {
        this.hasText.set(hasText);
    }

    public void setHasError() {
        hasError.set(true);
    }

    public void setIsLoading() {
        isLoading.set(true);
    }

    public void setIsIdle() {
        hasError.set(false);
        isLoading.set(false);
    }

}
