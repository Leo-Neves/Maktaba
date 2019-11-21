package com.leoneves.maktaba.snackbottombar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

/**
 * Created by leo on 02/06/16.
 */
public class BottomBarNavigationItem {

    private String title = "";
    private Drawable drawable;
    private int color = Color.GRAY;
    private Object tag;
    private boolean error;

    private
    @StringRes
    int titleRes = 0;
    private
    @DrawableRes
    int drawableRes = 0;
    private
    @ColorRes
    int colorRes = 0;

    /**
     * Constructor
     *
     * @param title    Title
     * @param resource Drawable resource
     */
    public BottomBarNavigationItem(String title, int resource) {
        this.title = title;
        this.drawableRes = resource;
    }

    /**
     * @param title    Title
     * @param resource Drawable resource
     * @param color    Background color
     */
    public BottomBarNavigationItem(String title, int resource, int color) {
        this.title = title;
        this.drawableRes = resource;
        this.color = color;
    }

    /**
     * Constructor
     *
     * @param titleRes    String resource
     * @param drawableRes Drawable resource
     * @param colorRes    Color resource
     */
    public BottomBarNavigationItem(@StringRes int titleRes, @DrawableRes int drawableRes, @ColorRes int colorRes) {
        this.titleRes = titleRes;
        this.drawableRes = drawableRes;
        this.colorRes = colorRes;
    }

    /**
     * Constructor
     *
     * @param title    String
     * @param drawable Drawable
     * @param color    Color
     */
    public BottomBarNavigationItem(String title, Drawable drawable, @ColorInt int color) {
        this.title = title;
        this.drawable = drawable;
        this.color = color;
    }

    public String getTitle(Context context) {
        if (titleRes != 0) {
            return context.getString(titleRes);
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleRes = 0;
    }

    public void setTitle(@StringRes int titleRes) {
        this.titleRes = titleRes;
        this.title = "";
    }

    public int getColor(Context context) {
        if (colorRes != 0) {
            return ContextCompat.getColor(context, colorRes);
        }
        return color;
    }

    public void setColor(@ColorInt int color) {
        this.color = color;
        this.colorRes = 0;
    }

    public void setColorRes(@ColorRes int colorRes) {
        this.colorRes = colorRes;
        this.color = 0;
    }

    public Drawable getDrawable(Context context) {
        if (drawableRes != 0) {
            return ContextCompat.getDrawable(context, drawableRes);
        }
        return drawable;
    }

    public void setDrawable(@DrawableRes int drawableRes) {
        this.drawableRes = drawableRes;
        this.drawable = null;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        this.drawableRes = 0;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
