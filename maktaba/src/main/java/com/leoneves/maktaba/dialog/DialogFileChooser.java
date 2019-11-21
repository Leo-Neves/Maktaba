package com.leoneves.maktaba.dialog;

import android.app.Activity;
import android.os.Environment;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.leoneves.maktaba.dialog.storagechooser.StorageChooser;
import com.leoneves.maktaba.dialog.storagechooser.utils.FileExtension;

/**
 * Created by edson on 13/10/16.
 */
public class DialogFileChooser {

    private StorageChooser chooser;

    // filter on file extension
    private List<FileExtension> fileExtensions = new ArrayList<>();
    public DialogFileChooser addExtension(String extension) {
        if (extension!=null)
            fileExtensions.add(FileExtension.getByName(extension.toLowerCase()));
        return this;
    }

    // file selection event handling
    public interface FileSelectedListener {
        void fileSelected(File file);
    }
    public DialogFileChooser setFileListener(FileSelectedListener fileListener) {
        this.fileListener = fileListener;
        return this;
    }
    private FileSelectedListener fileListener;

    public DialogFileChooser(StorageChooser.Builder builder){
        init(builder);
    }

    public DialogFileChooser (Activity activity) {
        StorageChooser.Builder builder = new StorageChooser.Builder();
        builder.withMemoryBar(false);
        builder.allowAddFolder(false);
        builder.allowCustomPath(true);
        builder.withPredefinedPath(Environment.getExternalStorageDirectory().getPath());
        builder.setType(StorageChooser.FILE_PICKER);
        builder.skipOverview(true);
        builder.withActivity(activity);
        init(builder);
    }

    private void init(@NonNull StorageChooser.Builder builder){
        fileExtensions = new ArrayList<>();
        chooser = builder.build();
        chooser.setOnSelectListener(new StorageChooser.OnSelectListener() {
            @Override
            public void onSelect(String path) {
                String extension = path.substring(path.lastIndexOf(".") + 1, path.length());
                FileExtension fileExtension = FileExtension.getByName(extension);
                if (fileListener!=null){
                    if (fileExtensions.isEmpty())
                        fileListener.fileSelected(new File(path));
                    else for(FileExtension fex : fileExtensions){
                        if (fex.equals(fileExtension))
                            fileListener.fileSelected(new File(path));
                    }
                }
            }
        });
    }

    public void showDialog() {
        chooser.show();
    }


}
