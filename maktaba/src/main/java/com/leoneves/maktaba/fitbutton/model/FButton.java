package com.leoneves.maktaba.fitbutton.model;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;

public class FButton {
    Drawable icon= null;
    int iconColor = 0;
    float iconWidth = 0f;
    float iconHeight = 0f;
    float iconMarginStart = 0f;
    float iconMarginTop = 0f;
    float iconMarginEnd = 0f;
    float iconMarginBottom = 0f;
    IconPosition iconPosition = IconPosition.CENTER;
    int iconVisibility = View.VISIBLE;

    int divColor = 0;
    float divWidth = 0f;
    float divHeight = 0f;
    float divMarginTop = 0f;
    float divMarginBottom = 0f;
    float divMarginStart = 0f;
    float divMarginEnd = 0f;
    int divVisibility = View.VISIBLE;

    String text= null;
    float textPaddingStart = 0f;
    float textPaddingTop = 0f;
    float textPaddingEnd = 0f;
    float textPaddingBottom = 0f;
    int fontRes = 0;
    Typeface textFont = Typeface.DEFAULT;
    int textStyle = Typeface.NORMAL;
    float textSize = 16f;
    int textColor = 0;
    boolean textAllCaps = false;
    int textVisibility = View.VISIBLE;

    int width = 0;
    int height = 0;
    int btnColor = 0;
    int disableColor = 0;
    int elementsDisableColor = 0;
    float cornerRadius = 0f;
    boolean enableRipple = true;
    int rippleColor = 0;
    Shape btnShape= Shape.RECTANGLE;
    boolean enable = true;
    int borderColor = 0;
    float borderWidth = 0f;
    float elevation = 0f;

    public FButton(Drawable icon, int iconColorint, float iconWidthint, float iconHeightint, float iconMarginStartint, float iconMarginTopint, float iconMarginEndint, float iconMarginBottomint, IconPosition iconPosition, int iconVisibilityint, int divColorint, float divWidthint, float divHeightint, float divMarginTopint, float divMarginBottomint, float divMarginStartint, float divMarginEndint, int divVisibilityint, String text, float textPaddingStartint, float textPaddingTopint, float textPaddingEndint, float textPaddingBottomint, int fontResint, Typeface textFontint, int textStyleint, float textSizeint, int textColorint, boolean textAllCapsint, int textVisibilityint, int widthint, int heightint, int btnColorint, int disableColorint, int elementsDisableColorint, float cornerRadiusint, boolean enableRippleint, int rippleColorint, Shape btnShape, boolean enableint, int borderColorint, float borderWidthint, float elevationint) {
        this.icon = icon;
        this.iconColor = iconColorint;
        this.iconWidth = iconWidthint;
        this.iconHeight = iconHeightint;
        this.iconMarginStart = iconMarginStartint;
        this.iconMarginTop = iconMarginTopint;
        this.iconMarginEnd = iconMarginEndint;
        this.iconMarginBottom = iconMarginBottomint;
        this.iconPosition = iconPosition;
        this.iconVisibility = iconVisibilityint;
        this.divColor = divColorint;
        this.divWidth = divWidthint;
        this.divHeight = divHeightint;
        this.divMarginTop = divMarginTopint;
        this.divMarginBottom = divMarginBottomint;
        this.divMarginStart = divMarginStartint;
        this.divMarginEnd = divMarginEndint;
        this.divVisibility = divVisibilityint;
        this.text = text;
        this.textPaddingStart = textPaddingStartint;
        this.textPaddingTop = textPaddingTopint;
        this.textPaddingEnd = textPaddingEndint;
        this.textPaddingBottom = textPaddingBottomint;
        this.fontRes = fontResint;
        this.textFont = textFontint;
        this.textStyle = textStyleint;
        this.textSize = textSizeint;
        this.textColor = textColorint;
        this.textAllCaps = textAllCapsint;
        this.textVisibility = textVisibilityint;
        this.width = widthint;
        this.height = heightint;
        this.btnColor = btnColorint;
        this.disableColor = disableColorint;
        this.elementsDisableColor = elementsDisableColorint;
        this.cornerRadius = cornerRadiusint;
        this.enableRipple = enableRippleint;
        this.rippleColor = rippleColorint;
        this.btnShape = btnShape;
        this.enable = enableint;
        this.borderColor = borderColorint;
        this.borderWidth = borderWidthint;
        this.elevation = elevationint;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public int getIconColor() {
        return iconColor;
    }

    public void setIconColor(int iconColor) {
        this.iconColor = iconColor;
    }

    public float getIconWidth() {
        return iconWidth;
    }

    public void setIconWidth(float iconWidth) {
        this.iconWidth = iconWidth;
    }

    public float getIconHeight() {
        return iconHeight;
    }

    public void setIconHeight(float iconHeight) {
        this.iconHeight = iconHeight;
    }

    public float getIconMarginStart() {
        return iconMarginStart;
    }

    public void setIconMarginStart(float iconMarginStart) {
        this.iconMarginStart = iconMarginStart;
    }

    public float getIconMarginTop() {
        return iconMarginTop;
    }

    public void setIconMarginTop(float iconMarginTop) {
        this.iconMarginTop = iconMarginTop;
    }

    public float getIconMarginEnd() {
        return iconMarginEnd;
    }

    public void setIconMarginEnd(float iconMarginEnd) {
        this.iconMarginEnd = iconMarginEnd;
    }

    public float getIconMarginBottom() {
        return iconMarginBottom;
    }

    public void setIconMarginBottom(float iconMarginBottom) {
        this.iconMarginBottom = iconMarginBottom;
    }

    public IconPosition getIconPosition() {
        return iconPosition;
    }

    public void setIconPosition(IconPosition iconPosition) {
        this.iconPosition = iconPosition;
    }

    public int getIconVisibility() {
        return iconVisibility;
    }

    public void setIconVisibility(int iconVisibility) {
        this.iconVisibility = iconVisibility;
    }

    public int getDivColor() {
        return divColor;
    }

    public void setDivColor(int divColor) {
        this.divColor = divColor;
    }

    public float getDivWidth() {
        return divWidth;
    }

    public void setDivWidth(float divWidth) {
        this.divWidth = divWidth;
    }

    public float getDivHeight() {
        return divHeight;
    }

    public void setDivHeight(float divHeight) {
        this.divHeight = divHeight;
    }

    public float getDivMarginTop() {
        return divMarginTop;
    }

    public void setDivMarginTop(float divMarginTop) {
        this.divMarginTop = divMarginTop;
    }

    public float getDivMarginBottom() {
        return divMarginBottom;
    }

    public void setDivMarginBottom(float divMarginBottom) {
        this.divMarginBottom = divMarginBottom;
    }

    public float getDivMarginStart() {
        return divMarginStart;
    }

    public void setDivMarginStart(float divMarginStart) {
        this.divMarginStart = divMarginStart;
    }

    public float getDivMarginEnd() {
        return divMarginEnd;
    }

    public void setDivMarginEnd(float divMarginEnd) {
        this.divMarginEnd = divMarginEnd;
    }

    public int getDivVisibility() {
        return divVisibility;
    }

    public void setDivVisibility(int divVisibility) {
        this.divVisibility = divVisibility;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getTextPaddingStart() {
        return textPaddingStart;
    }

    public void setTextPaddingStart(float textPaddingStart) {
        this.textPaddingStart = textPaddingStart;
    }

    public float getTextPaddingTop() {
        return textPaddingTop;
    }

    public void setTextPaddingTop(float textPaddingTop) {
        this.textPaddingTop = textPaddingTop;
    }

    public float getTextPaddingEnd() {
        return textPaddingEnd;
    }

    public void setTextPaddingEnd(float textPaddingEnd) {
        this.textPaddingEnd = textPaddingEnd;
    }

    public float getTextPaddingBottom() {
        return textPaddingBottom;
    }

    public void setTextPaddingBottom(float textPaddingBottom) {
        this.textPaddingBottom = textPaddingBottom;
    }

    public int getFontRes() {
        return fontRes;
    }

    public void setFontRes(int fontRes) {
        this.fontRes = fontRes;
    }

    public Typeface getTextFont() {
        return textFont;
    }

    public void setTextFont(Typeface textFont) {
        this.textFont = textFont;
    }

    public int getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(int textStyle) {
        this.textStyle = textStyle;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public boolean isTextAllCaps() {
        return textAllCaps;
    }

    public boolean getTextAllCaps() {
        return textAllCaps;
    }

    public void setTextAllCaps(boolean textAllCaps) {
        this.textAllCaps = textAllCaps;
    }

    public int getTextVisibility() {
        return textVisibility;
    }

    public void setTextVisibility(int textVisibility) {
        this.textVisibility = textVisibility;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(int btnColor) {
        this.btnColor = btnColor;
    }

    public int getDisableColor() {
        return disableColor;
    }

    public void setDisableColor(int disableColor) {
        this.disableColor = disableColor;
    }

    public int getElementsDisableColor() {
        return elementsDisableColor;
    }

    public void setElementsDisableColor(int elementsDisableColor) {
        this.elementsDisableColor = elementsDisableColor;
    }

    public float getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public boolean getEnableRipple() {
        return enableRipple;
    }

    public void setEnableRipple(boolean enableRipple) {
        this.enableRipple = enableRipple;
    }

    public int getRippleColor() {
        return rippleColor;
    }

    public void setRippleColor(int rippleColor) {
        this.rippleColor = rippleColor;
    }

    public Shape getBtnShape() {
        return btnShape;
    }

    public void setBtnShape(Shape btnShape) {
        this.btnShape = btnShape;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
    }

    public float getElevation() {
        return elevation;
    }

    public void setElevation(float elevation) {
        this.elevation = elevation;
    }
}
