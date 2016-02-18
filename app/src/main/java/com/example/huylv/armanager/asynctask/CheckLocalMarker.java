package com.example.huylv.armanager.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.huylv.armanager.MainActivity;
import com.example.huylv.armanager.fragment.ManagerFragment;
import com.example.huylv.armanager.model.Marker;
import com.example.huylv.armanager.util.Util;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by huylv on 18/02/2016.
 */
public class CheckLocalMarker extends AsyncTask<Void,Void,Integer> {

    Context context;
    ManagerFragment managerFragment;
    FrameLayout flProgressBar;

    public CheckLocalMarker(Context c,ManagerFragment mf){
        context=c;
        managerFragment=mf;
        this.flProgressBar = ((MainActivity)c).flProgressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Integer doInBackground(Void... params) {

        //create root directory
        File rootFolder = new File(Environment.getExternalStorageDirectory() + File.separator + "ARManager");
        boolean success = true;
        if(!rootFolder.exists()){
            success = rootFolder.mkdir();
        }else{
            Log.e("cxz", "folder exist");
        }
        if(success){
            Log.e("cxz","root folder created");
        }else{
            Log.e("cxz","create error");
            return -4;
        }

        //check file
        String path = rootFolder.getPath();
        Log.e("cxz", "Path: " + path);
        Util.PATH_AR = path;
        File file[] = new File(path).listFiles();
        Log.e("cxz", "Size: " + file.length);
        int i=0;
        Util.markerList = new ArrayList<>();
        while(i<file.length){
            if(Util.getFileExt(file[i].getName()).equals("fset")){
                String markerName = Util.getFileName(file[i].getName());

                if(Util.getFileName(file[i + 1].getName()).equals(markerName)){
                    if(Util.getFileName(file[i + 2].getName()).equals(markerName)){
                        Marker m = new Marker(file[i],file[i+1],file[i+2],(Util.markerList.size()%3),markerName);
                        Util.markerList.add(m);
                        Log.e("cxz","marker:"+m);
                    }else{
                        return -1;
                    }
                }else{
                    return -2;
                }
            }
            i+=3;
        }

        return 1;
    }

    @Override
    protected void onPostExecute(Integer aVoid) {
        super.onPostExecute(aVoid);
        Log.e("cxz", "return code " + aVoid);

        flProgressBar.setVisibility(View.GONE);
        switch (aVoid){
            case 1:
//                managerFragment.markerListAdapter.notifyDataSetChanged();
                break;
        }

    }
}
