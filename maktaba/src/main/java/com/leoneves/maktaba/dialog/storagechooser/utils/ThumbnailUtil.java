package com.leoneves.maktaba.dialog.storagechooser.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.leoneves.maktaba.R;

public class ThumbnailUtil {
    private Context mContext;

    public ThumbnailUtil(Context mContext) {
        this.mContext = mContext;
    }

    public void init(ImageView imageView, String filePath) {
        thumbnailPipe(imageView, filePath);
    }

    private void thumbnailPipe(ImageView imageView, String filePath) {
        FileExtension extension = getExtension(filePath);
        if (extension==null)
            return;
        switch (extension) {
            case TEXT_FILE:
            case CSV_FILE:
            case DOC_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_doc));
                break;
            case PROP_FILE:
            case XML_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_doc));
                break;
            case VIDEO_FILE:
            case VIDEO_AVI_FILE:
            case VIDEO_MOV_FILE:
            case VIDEO_MKV_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_mov));
                break;
            case APK_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_apk));
                break;
            case CAR_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_car));
                break;
            case GPX_FILE:
            case SHP_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_globe));
                break;
            case REALM_FILE:
            case SQLITE_FILE:
            case DBF_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_database));
                break;
            case MP3_FILE:
            case WAV_FILE:
            case WMF_FILE:
            case OGG_FILE:
            case AAC_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_music));
                break;
            case ZIP_FILE:
            case RAR_FILE:
            case TAR_FILE:
            case TAR_GZ_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_zip));
                break;
            case JPEG_FILE:
            case JPG_FILE:
            case PNG_FILE:
            case GIF_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_pic));
                break;
            case TTF_FILE:
            case OTF_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_font));
                break;
            case HTML_FILE:
            case PHP_FILE:
            case CSS_FILE:
            case CR_DL_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_web));
                break;
            case TORRENtT_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_torrent));
                break;
            case PDF_FILE:
                imageView.setImageDrawable(getDrawableFromRes(R.drawable.dialog_pdf));
                break;
        }
    }

    private Drawable getDrawableFromRes(int id) {
        return ContextCompat.getDrawable(mContext, id);
    }

    private FileExtension getExtension(String path) {
        return FileExtension.getByName(path.substring(path.lastIndexOf(".") + 1, path.length()));
    }
}
