package com.mbmc.template.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GlideImageLoader implements ImageLoader {

    @Override
    public void get(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

}
