package com.mbmc.template.ui.component;

import android.content.Context;
import android.util.AttributeSet;


public class ProgressBar extends android.widget.ProgressBar {

    // Prevent espresso from waiting
    public static boolean isIndeterminate = true;


    public ProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isIndeterminate) {
            setVisibility(GONE);
        }
    }

}
