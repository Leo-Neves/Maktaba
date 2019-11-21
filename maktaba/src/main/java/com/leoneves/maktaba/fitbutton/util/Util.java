package com.leoneves.maktaba.fitbutton.util;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * The [FitButton] utils
 * @author Ivan V on 27.03.2019.
 * @version 1.0
 */

public class Util {


    public static float dpToPx( float dp){
        return TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem()
                        .getDisplayMetrics());
    }

    public static float pxToDp( float px){
        return TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_PX, px, Resources.getSystem()
                        .getDisplayMetrics());
    }

    public static float txtPxToSp(float px ){
        return TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_SP, px, Resources.getSystem()
                        .getDisplayMetrics());
    }

    public static float getDensity(){
        return Resources.getSystem().getDisplayMetrics().density;
    }
}
