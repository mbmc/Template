package com.mbmc.template.helper;

import android.content.Context;
import android.widget.ImageView;

import com.mbmc.template.R;


public class TestImageLoader implements ImageLoader {

    @Override
    public void get(Context context, String url, ImageView imageView) {
        imageView.setImageResource(R.mipmap.ic_launcher);
    }

}
