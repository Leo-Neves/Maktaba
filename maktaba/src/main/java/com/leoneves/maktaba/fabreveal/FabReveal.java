package com.leoneves.maktaba.fabreveal;

/**
 * Created by leo on 09/02/18.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.leoneves.maktaba.R;
import com.leoneves.maktaba.fabreveal.widget.AnimatedFab;
import com.leoneves.maktaba.fabreveal.widget.FabRevealEventListener;
import com.leoneves.maktaba.fabreveal.widget.FabRevealFactory;

/**
 * Created by Gordon Wong on 7/17/2015.
 *
 * Sample floating action button implementation.
 */
public class FabReveal extends FloatingActionButton implements AnimatedFab {

    private static final int FAB_ANIM_DURATION = 200;

    private int contentId;
    private int overlayId;
    private int contentColor;
    private int overlayColor;
    private FabRevealFactory<FabReveal> fabFactory;

    public FabReveal(Context context) {
        super(context);
    }

    public FabReveal(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FabReveal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FabReveal);
        this.contentId = typedArray.getResourceId(R.styleable.FabReveal_fr_content,-1);
        this.overlayId = typedArray.getResourceId(R.styleable.FabReveal_fr_overlay,-1);
        this.contentColor = typedArray.getColor(R.styleable.FabReveal_fr_contentColor, Color.WHITE);
        this.overlayColor = typedArray.getColor(R.styleable.FabReveal_fr_overlayColor, Color.BLACK);
    }

    /**
     * Shows the FAB.
     */
    @Override
    public void show() {
        show(0, 0);
    }

    /**
     * Shows the FAB and sets the FAB's translation.
     *
     * @param translationX translation X value
     * @param translationY translation Y value
     */
    @Override
    public void show(float translationX, float translationY) {
        // Set FAB's translation
        setTranslation(translationX, translationY);

        // Only use scale animation if FAB is hidden
        if (getVisibility() != View.VISIBLE) {
            // Pivots indicate where the animation begins from
            float pivotX = getPivotX() + translationX;
            float pivotY = getPivotY() + translationY;

            ScaleAnimation anim;
            // If pivots are 0, that means the FAB hasn't been drawn yet so just use the
            // center of the FAB
            if (pivotX == 0 || pivotY == 0) {
                anim = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
            } else {
                anim = new ScaleAnimation(0, 1, 0, 1, pivotX, pivotY);
            }

            // Animate FAB expanding
            anim.setDuration(FAB_ANIM_DURATION);
            anim.setInterpolator(getInterpolator());
            startAnimation(anim);
        }
        setVisibility(View.VISIBLE);
    }

    /**
     * Hides the FAB.
     */
    @Override
    public void hide() {
        // Only use scale animation if FAB is visible
        if (getVisibility() == View.VISIBLE) {
            // Pivots indicate where the animation begins from
            float pivotX = getPivotX() + getTranslationX();
            float pivotY = getPivotY() + getTranslationY();

            // Animate FAB shrinking
            ScaleAnimation anim = new ScaleAnimation(1, 0, 1, 0, pivotX, pivotY);
            anim.setDuration(FAB_ANIM_DURATION);
            anim.setInterpolator(getInterpolator());
            startAnimation(anim);
        }
        setVisibility(View.INVISIBLE);
    }

    private void setTranslation(float translationX, float translationY) {
        animate().setInterpolator(getInterpolator()).setDuration(FAB_ANIM_DURATION)
                .translationX(translationX).translationY(translationY);
    }

    private Interpolator getInterpolator() {
        return AnimationUtils.loadInterpolator(getContext(), R.interpolator.msf_interpolator);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initFabFactory(){
        if (fabFactory==null && contentId!=-1){
            View content = ((ViewGroup)getParent()).findViewById(contentId);
            View overlay = ((ViewGroup)getParent()).findViewById(overlayId);
            if (content!=null){
                fabFactory = new FabRevealFactory<>(this, content, overlay, contentColor, overlayColor);
            }
        }
    }

    /**
     * Shows the FAB.
     */
    public void showFab() {
        if (fabFactory!=null)
            fabFactory.showFab();
        else initFabFactory();
    }

    /**
     * Shows the FAB and sets the FAB's translation.
     *
     * @param translationX translation X value
     * @param translationY translation Y value
     */
    public void showFab(float translationX, float translationY) {
        if (fabFactory!=null)
            fabFactory.showFab(translationX, translationY);
        else initFabFactory();
    }

    /**
     * Shows the sheet.
     */
    public void showSheet() {
        if (fabFactory!=null)
            fabFactory.showSheet();
        else initFabFactory();
    }

    /**
     * Hides the sheet.
     */
    public void hideSheet() {
        if (fabFactory!=null)
            fabFactory.hideSheet();
        else initFabFactory();
    }

    /**
     * Hides the sheet (if visible) and then hides the FAB.
     */
    public void hideSheetThenFab() {
        if (fabFactory!=null)
            fabFactory.hideSheetThenFab();
        else initFabFactory();
    }

    public boolean isSheetVisible() {
        if (fabFactory!=null)
            return fabFactory.isSheetVisible();
        else initFabFactory();
            return false;
    }

    public void setEventListener(FabRevealEventListener eventListener) {
        if (fabFactory!=null)
            fabFactory.setEventListener(eventListener);
        else initFabFactory();
    }
}