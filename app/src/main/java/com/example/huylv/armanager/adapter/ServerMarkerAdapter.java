package com.example.huylv.armanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.huylv.armanager.R;
import com.example.huylv.armanager.model.ServerMarker;

import java.util.ArrayList;

/**
 * Created by huylv on 23-Feb-16.
 */
public class ServerMarkerAdapter extends RecyclerView.Adapter<ServerMarkerAdapter.ServerMarkerHolder> {
    ArrayList<ServerMarker> serverMarkerArrayList;
    Context context;

    public ServerMarkerAdapter(Context c, ArrayList<ServerMarker> rm) {
        serverMarkerArrayList = rm;
        context = c;
    }

    @Override
    public ServerMarkerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marker_server, null);
        ServerMarkerHolder viewHolder = new ServerMarkerHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return serverMarkerArrayList.size();
    }

    @Override
    public void onBindViewHolder(ServerMarkerHolder holder, int position) {
        ServerMarker r = serverMarkerArrayList.get(position);
        holder.tvMarkerServerName.setText(r.getName());
    }

    class ServerMarkerHolder extends RecyclerView.ViewHolder {

        TextView tvMarkerServerName;
        Button btMarkerServerDownload;

        ServerMarkerHolder(View v) {
            super(v);
            this.tvMarkerServerName = (TextView) v.findViewById(R.id.tvMarkerServerName);
            this.btMarkerServerDownload = (Button) v.findViewById(R.id.btMarkerServerDownload);
        }
    }
}
