package com.leoneves.maktaba.dialog.storagechooser.utils;

import org.jetbrains.annotations.NotNull;

public enum FileExtension {
    TEXT_FILE("txt"),
    CSV_FILE("csv"),
    PROP_FILE("prop"),
    XML_FILE("xml"),
    // video files
    VIDEO_FILE("mp4"),
    VIDEO_MOV_FILE("mov"),
    VIDEO_AVI_FILE("avi"),
    VIDEO_MKV_FILE("mkv"),
    // audio files
    MP3_FILE("mp3"),
    OGG_FILE("ogg"),
    WMF_FILE("wmf"),
    WAV_FILE("wav"),
    AAC_FILE("aac"),
    // image files
    JPEG_FILE("jpeg"),
    JPG_FILE("jpg"),
    PNG_FILE("png"),
    GIF_FILE("gif"),
    //archive files
    APK_FILE("apk"),
    ZIP_FILE("zip"),
    RAR_FILE("rar"),
    TAR_GZ_FILE("gz"),
    TAR_FILE("tar"),

    // office files
    DOC_FILE("doc"),
    PPT_FILE("ppt"),
    EXCEL_FILE("xls"),
    PDF_FILE("pdf"),

    //car files
    CAR_FILE("car"),

    //font files
    TTF_FILE("ttf"),
    OTF_FILE("otf"),

    //torrent files
    TORRENtT_FILE("torrent"),

    //database files
    REALM_FILE("realm"),
    SQLITE_FILE("db"),
    DBF_FILE("dbf"),

    //globe files
    GPX_FILE("gpx"),
    SHP_FILE("shp"),

    //web files
    HTML_FILE("html"),
    PHP_FILE("php"),
    CSS_FILE("css"),
    CR_DL_FILE("crdownload");
    
    private String extension;
    FileExtension(String extension){
        this.extension = extension;
    }

    public static FileExtension getByName(String extension){
        if (extension!=null)
            for (FileExtension fileExtension : FileExtension.values())
                if (fileExtension.toString().equals(extension.toLowerCase()))
                    return fileExtension;
        return null;
    }
    
    @NotNull
    @Override
    public String toString(){
        return extension;
    }
}
