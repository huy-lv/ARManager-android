package com.example.huylv.armanager.model;

/**
 * Created by huylv on 23-Feb-16.
 */
public class PostImage {
    String file;//string code base64
    String fileName;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public PostImage(String file, String fileName) {

        this.file = file;
        this.fileName = fileName;
    }
}
