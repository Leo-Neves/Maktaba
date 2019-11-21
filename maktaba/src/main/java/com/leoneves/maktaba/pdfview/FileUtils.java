package com.leoneves.maktaba.pdfview;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class FileUtils {

    public static  File fileFromAsset(Context context, String assetFileName) throws IOException{
        File outFile = new File(context.getCacheDir(), "$assetFileName-pdfview.pdf");
        if (assetFileName.contains("/")) {
            outFile.getParentFile().mkdirs();
        }

        InputStream initialStream = context.getAssets().open(assetFileName);
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        OutputStream outStream = new FileOutputStream(outFile);
        outStream.write(buffer);
        return outFile;
    }
}
