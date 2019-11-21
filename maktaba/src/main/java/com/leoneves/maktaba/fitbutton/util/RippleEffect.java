package com.leoneves.maktaba.fitbutton.util;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;

import com.leoneves.maktaba.fitbutton.model.Shape;
import static com.leoneves.maktaba.fitbutton.util.Util.pxToDp;

public class RippleEffect {

    public static void createRipple(View view, boolean enableRipple, int normalColor, int rippleColor, float corner, Shape shape, GradientDrawable container){
        if (enableRipple){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                GradientDrawable mask = new GradientDrawable();
                mask.setCornerRadius(pxToDp(corner));
                mask.setColor(Color.GRAY);
                mask.setShape(shape.equals(Shape.RECTANGLE) || shape.equals(Shape.SQUARE) ? GradientDrawable.RECTANGLE : GradientDrawable.OVAL);
                ColorStateList colors = new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}},new int[]{rippleColor});
                RippleDrawable rd = new RippleDrawable(colors, container, mask);
                view.setBackground(rd);
            }else{
                StateListDrawable sd = new StateListDrawable();
                int[] statePressed = new int[]{android.R.attr.state_pressed};
                int[] stateNormal = new int[]{android.R.attr.state_enabled};

                GradientDrawable pressed = new GradientDrawable();
                pressed.setColor(rippleColor);
                pressed.setCornerRadius(corner);
                int shp = shape.equals(Shape.RECTANGLE)|| shape.equals(Shape.SQUARE) ?  GradientDrawable.RECTANGLE : GradientDrawable.OVAL;
                pressed.setShape(shp);
                container.setColor(normalColor);
                container.setCornerRadius(corner);

                sd.addState(statePressed, pressed);
                sd.addState(stateNormal, container);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(sd);
                }
            }
        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(container);
            }
        }
    }
}
