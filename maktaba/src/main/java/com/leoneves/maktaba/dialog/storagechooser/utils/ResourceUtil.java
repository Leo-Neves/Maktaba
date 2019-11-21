package com.leoneves.maktaba.dialog.storagechooser.utils;


import android.content.Context;

import androidx.core.content.ContextCompat;

public class ResourceUtil {

    private Context context;

    public ResourceUtil(Context context) {
        this.context = context;
    }

    public int getColor(int id) {
        return ContextCompat.getColor(context, id);
    }
}
