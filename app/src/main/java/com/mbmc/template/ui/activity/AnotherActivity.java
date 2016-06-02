package com.mbmc.template.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.mbmc.template.R;


public class AnotherActivity extends BaseActivity {

    private static final String TAG = "AnotherActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Log.d(TAG, "uiComponent: " + getUiComponent()); // It's different for each instance
    }

}
