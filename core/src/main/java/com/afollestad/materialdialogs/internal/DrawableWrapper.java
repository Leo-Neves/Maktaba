package com.afollestad.materialdialogs.internal;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/**
 * Created by leo on 05/02/16.
 */
public interface DrawableWrapper {

    void setTint(int tint);

    void setTintList(ColorStateList tint);

    void setTintMode(PorterDuff.Mode tintMode);

    Drawable getWrappedDrawable();

    void setWrappedDrawable(Drawable drawable);

}