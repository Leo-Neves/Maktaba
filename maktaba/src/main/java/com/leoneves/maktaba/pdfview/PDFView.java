package com.leoneves.maktaba.pdfview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.leoneves.maktaba.pdfview.decoder.DecoderFactory;
import com.leoneves.maktaba.pdfview.decoder.ImageRegionDecoder;

public class PDFView extends SubsamplingScaleImageView{
    private Context context;

    public PDFView(Context context, AttributeSet attrs){
            super(context, attrs);
            this.context = context;
            init();
    }

    public PDFView(Context context){
        super(context);
        this.context = context;
        init();
    }

    private File mfile;
    private float mScale = 8f;

    private void init() {
        setMinimumTileDpi(120);
        setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_START);
    }

    public PDFView fromAsset(String assetFileName){
        try {
            mfile = FileUtils.fileFromAsset(context, assetFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public PDFView fromFile(File file){
        mfile = file;
        return this;
    }

    public PDFView fromFile(String filePath){
        mfile = new File(filePath);
        return this;
    }

    public PDFView scale(float scale){
        mScale = scale;
        return this;
    }

    public void show() {
        if (mfile!=null) {
            ImageSource source = ImageSource.uri(mfile.getPath());
            setRegionDecoderFactory(new DecoderFactory<ImageRegionDecoder>() {
                @NonNull
                @Override
                public ImageRegionDecoder make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
                    return new PDFRegionDecoder(PDFView.this, mfile, mScale);
                }
            });
            setImage(source);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.recycle();
    }
}