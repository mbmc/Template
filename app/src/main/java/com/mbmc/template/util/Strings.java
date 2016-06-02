package com.mbmc.template.util;

import android.text.TextUtils;


public final class Strings {

   public static String getRepoName(String string) {
       string = string.trim();
       if (TextUtils.isEmpty(string)) {
           return "";
       }
       return string.split("/")[1]; // owner/repo
   }


    private Strings() {
        // Don't construct
    }

}
