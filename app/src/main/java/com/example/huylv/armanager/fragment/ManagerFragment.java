package com.example.huylv.armanager.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.huylv.armanager.DownloadFileFromUrl;
import com.example.huylv.armanager.R;

/**
 * Created by huylv on 16-Feb-16.
 */
public class ManagerFragment extends Fragment{

    public static final int progress_bar_type=0;
    ProgressDialog pDialog;
    Button btDownload;
    private static String file_url = "http://api.androidhive.info/progressdialog/hive.jpg";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manager,container,false);




        btDownload = (Button) v.findViewById(R.id.btDownload);
        btDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadFileFromUrl().execute(file_url);
            }
        });

        return v;
    }



}
