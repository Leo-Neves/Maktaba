package com.leoneves.maktaba.pdfview;

import android.content.Context;
import android.graphics.*;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

import static com.leoneves.maktaba.pdfview.SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE;
import com.leoneves.maktaba.pdfview.decoder.ImageRegionDecoder;
import java.io.File;
import java.io.IOException;

class PDFRegionDecoder implements ImageRegionDecoder{

    PDFRegionDecoder(PDFView view,
                     File file,
                     float scale){
        this.view = view;
        this.file = file;
        this.scale = scale;

        }

    private PDFView view;
    private File file;
    private float scale;
    @ColorInt
    private int backgroundColorPdf = Color.WHITE;
    private ParcelFileDescriptor descriptor;
    private PdfRenderer renderer;
    private int pageWidth = 0;
    private int pageHeight = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Point init(Context context, Uri uri) throws Exception{
        descriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
        renderer = new PdfRenderer(descriptor);
        PdfRenderer.Page page = renderer.openPage(0);
        pageWidth = (int) (page.getWidth() * scale);
        pageHeight = (int) (page.getHeight() * scale);
        if (renderer.getPageCount() > 15) {
            view.setHasBaseLayerTiles(false);
        } else if (renderer.getPageCount() == 1) {
            view.setMinimumScaleType(SCALE_TYPE_CENTER_INSIDE);
        }
        page.close();
        return new Point(pageWidth,pageHeight * renderer.getPageCount());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Bitmap decodeRegion(Rect rect, int sampleSize){
        int numPageAtStart = (int)(Math.floor(((double)rect.top) / pageHeight));
        int numPageAtEnd = ((int)(Math.ceil((double)(rect.bottom) / pageHeight))) - 1;
        Bitmap bitmap = Bitmap.createBitmap(rect.width() / sampleSize, rect.height() / sampleSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(backgroundColorPdf);
        canvas.drawBitmap(bitmap, 0f, 0f, null);
        for (int pageIndex=numPageAtStart; pageIndex<numPageAtEnd; pageIndex++){
            synchronized(renderer) {
                PdfRenderer.Page page = renderer.openPage(pageIndex);
                Matrix matrix = new Matrix();
                matrix.setScale(scale / sampleSize, scale / sampleSize);
                matrix.postTranslate(
                        (float)(-rect.left / sampleSize), -((float)((rect.top - pageHeight * numPageAtStart) / sampleSize)) + (((float)pageHeight)/ sampleSize) * pageIndex);
                page.render(bitmap,null, matrix, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
                page.close();
            }
        }
        return bitmap;
    }

    public boolean isReady(){
        return pageWidth > 0 && pageHeight > 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void recycle() {
        renderer.close();
        try {
            descriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pageWidth = 0;
        pageHeight = 0;
    }
}