package com.example.huylv.armanager.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.widget.EditText;

import com.example.huylv.armanager.R;

import java.io.ByteArrayOutputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by huylv on 23-Feb-16.
 */
public class CreateDialog extends Dialog {

    @Bind(R.id.etCreateMarkerName)
    EditText etCreateMarkerName;

    String encoded;

    public CreateDialog(Context context, Bitmap bitmap) {
        super(context);
        setContentView(R.layout.dialog_create_marker);

        ButterKnife.bind(this);

        //encode to base64
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    @OnClick(R.id.btCreateMarker)
    public void createMarker() {
//        PostImage pi = new PostImage(encoded,etCreateMarkerName.getText().toString());
//        PostMarker p = new PostMarker()
//                Post2Marker p2 = new Post2Marker();
//        ServiceBuilder.getService().create();
    }

    @OnClick(R.id.btCreateCancel)
    public void cancel() {
        this.dismiss();
    }
}
