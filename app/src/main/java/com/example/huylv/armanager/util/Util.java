package com.example.huylv.armanager.util;

import com.example.huylv.armanager.model.Marker;

import java.util.ArrayList;

/**
 * Created by huylv on 16-Feb-16.
 */
public class Util {

    public static String PATH_AR;
    public static ArrayList<Marker> markerList;

    public static String getFileExt(String fileName) {
        return fileName.substring((fileName.lastIndexOf(".") + 1), fileName.length());
    }

    public static String getFileName(String fileName){
        return fileName.substring(0,(fileName.lastIndexOf(".")));
    }
}
