package com.mbmc.template.event;

public interface UserEventHandler {

    void onClicked();
    void onRetryClicked();
    void onTextChanged(CharSequence charSequence);

}
