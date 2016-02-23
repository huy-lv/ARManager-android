package com.example.huylv.armanager.util;

import android.app.AlertDialog;
import android.content.Context;

import com.example.huylv.armanager.R;
import com.example.huylv.armanager.model.Marker;

import java.util.ArrayList;

/**
 * Created by huylv on 16-Feb-16.
 */
public class Util {

    public static String PATH_AR;
    public static ArrayList<Marker> markerList;

    public static String SERVERURL = "http://hienbx912.esy.es/marker/";

    public static String getFileExt(String fileName) {
        return fileName.substring((fileName.lastIndexOf(".") + 1), fileName.length());
    }

    public static String getFileName(String fileName){
        return fileName.substring(0,(fileName.lastIndexOf(".")));
    }

    public static void showErrorDialog(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setTitle(R.string.title_error);
        builder.setPositiveButton(R.string.ok, null);
        builder.create().show();
    }
//    du lieu up len
//    {
//        marker:
//        {
//            :name => "abc",
//            :marker_path
//            {
//                :file => "base64 code",
//                :original_filename => "abc",
//                :filename => "abc"
//            }
//        }
//    }
//// Data tra ve
//
//    {
//        totals: 2,
//                markers: [
//        {
//            name: "abc",
//                    iset: "/public/marker/1/abc.iset",
//                fset: "/public/marker/1/abc.fset",
//                fset3: "/public/marker/1/abc.fset3",
//        },
//        {
//            name: "ccc",
//                    iset: "/public/marker/2/ccc.iset",
//                fset: "/public/marker/2/ccc.fset",
//                fset3: "/public/marker/2/ccc.fset3",
//        }
//        ]
//    }
}
