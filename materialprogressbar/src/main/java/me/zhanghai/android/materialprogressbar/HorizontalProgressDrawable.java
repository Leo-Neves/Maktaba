/*
 * Copyright (c) 2015 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

/**
 * A backported {@code Drawable} for determinate horizontal {@code ProgressBar}.
 */
public class HorizontalProgressDrawable extends LayerDrawable
        implements IntrinsicPaddingDrawable, ShowTrackDrawable {

    private int mSecondaryAlpha;
    private SingleHorizontalProgressDrawable mTrackDrawable;
    private SingleHorizontalProgressDrawable mSecondaryProgressDrawable;
    private SingleHorizontalProgressDrawable mProgressDrawable;

    /**
     * Create a new {@code HorizontalProgressDrawable}.
     *
     * @param context the {@code Context} for retrieving style information.
     */
    public HorizontalProgressDrawable(Context context, int color) {
        super(new Drawable[] {
                new SingleHorizontalProgressDrawable(context, color),
                new SingleHorizontalProgressDrawable(context, color),
                new SingleHorizontalProgressDrawable(context, color)
        });

        setId(0, android.R.id.background);
        mTrackDrawable = (SingleHorizontalProgressDrawable) getDrawable(0);

        setId(1, android.R.id.secondaryProgress);
        mSecondaryProgressDrawable = (SingleHorizontalProgressDrawable) getDrawable(1);
        float disabledAlpha = ThemeUtils.getFloatFromAttrRes(android.R.attr.disabledAlpha, context);
        mSecondaryAlpha = Math.round(disabledAlpha * 0xFF);
        mSecondaryProgressDrawable.setAlpha(mSecondaryAlpha);
        mSecondaryProgressDrawable.setShowTrack(false);

        setId(2, android.R.id.progress);
        mProgressDrawable = (SingleHorizontalProgressDrawable) getDrawable(2);
        mProgressDrawable.setShowTrack(false);
    }

    /**
     * {@inheritDoc}
     */
    public boolean getShowTrack() {
        return mTrackDrawable.getShowTrack();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShowTrack(boolean showTrack) {
        if (mTrackDrawable.getShowTrack() != showTrack) {
            mTrackDrawable.setShowTrack(showTrack);
            // HACK: Make alpha act as if composited.
            mSecondaryProgressDrawable.setAlpha(showTrack ? mSecondaryAlpha : 2 * mSecondaryAlpha);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getUseIntrinsicPadding() {
        return mTrackDrawable.getUseIntrinsicPadding();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUseIntrinsicPadding(boolean useIntrinsicPadding) {
        mTrackDrawable.setUseIntrinsicPadding(useIntrinsicPadding);
        mSecondaryProgressDrawable.setUseIntrinsicPadding(useIntrinsicPadding);
        mProgressDrawable.setUseIntrinsicPadding(useIntrinsicPadding);
    }

}
