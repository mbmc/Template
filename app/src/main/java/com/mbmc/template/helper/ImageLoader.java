package com.mbmc.template.helper;

import android.content.Context;
import android.widget.ImageView;


public interface ImageLoader {

    void get(Context context, String url, ImageView view);

}
