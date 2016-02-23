package com.example.huylv.armanager.fragment;

import android.app.Fragment;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.huylv.armanager.CameraSurface;
import com.example.huylv.armanager.MainActivity;
import com.example.huylv.armanager.R;
import com.example.huylv.armanager.Renderer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by huylv on 16-Feb-16.
 */
public class ScannerFragment extends Fragment {

    @Bind(R.id.flScanner)
    public FrameLayout flScanner;
    private GLSurfaceView glView;
    private CameraSurface camSurface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_scanner,container,false);
        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.nativeStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        camSurface = new CameraSurface(getActivity());
        glView = new GLSurfaceView(getActivity());
        glView.setRenderer(new Renderer());
        glView.setZOrderMediaOverlay(true); // Request that GL view's SurfaceView be on top of other SurfaceViews (including CameraPreview's SurfaceView).
        flScanner.addView(camSurface, new ViewGroup.LayoutParams(128, 128));
        flScanner.addView(glView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        if (glView != null) glView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (glView != null) glView.onPause();
        flScanner.removeView(glView);
        flScanner.removeView(camSurface);
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity.nativeStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.nativeDestroy();
    }

}
