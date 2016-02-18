package com.example.huylv.armanager.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.huylv.armanager.DownloadFileFromUrl;
import com.example.huylv.armanager.R;
import com.example.huylv.armanager.adapter.MarkerListAdapter;
import com.example.huylv.armanager.model.Marker;
import com.example.huylv.armanager.util.Util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by huylv on 16-Feb-16.
 */
public class ManagerFragment extends Fragment implements View.OnClickListener{

    public static final int progress_bar_type=0;
    ProgressDialog pDialog;
    private static String file_url = "http://api.androidhive.info/progressdialog/hive.jpg";


    RecyclerView rvMarkerList;
    ArrayList<Marker> markerArrayList;
    public MarkerListAdapter markerListAdapter;
    Button btCreateMarker;
    private static final int SELECT_PHOTO = 100;
    Button btGet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manager,container,false);

        markerArrayList = Util.markerList;


        rvMarkerList = (RecyclerView)v.findViewById(R.id.rvMarkerList);
        rvMarkerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        markerListAdapter = new MarkerListAdapter(getActivity(),markerArrayList);
        rvMarkerList.setAdapter(markerListAdapter);

        btCreateMarker = (Button)v.findViewById(R.id.btCreateMarker);
        btCreateMarker.setOnClickListener(this);
        btGet = (Button)v.findViewById(R.id.btGet);
        btGet.setOnClickListener(this);

//        btDownload = (Button) v.findViewById(R.id.btDownload);
//        btDownload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new DownloadFileFromUrl().execute(file_url);
//            }
//        });

        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btCreateMarker:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                break;
            case R.id.btGet:
                
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == Activity.RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    InputStream imageStream = null;
                    try {
                        imageStream = getActivity().getContentResolver().openInputStream(selectedImage);
                        Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                        Log.e("cxz",yourSelectedImage.toString());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }
}
