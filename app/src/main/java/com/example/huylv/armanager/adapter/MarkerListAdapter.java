package com.example.huylv.armanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.huylv.armanager.R;
import com.example.huylv.armanager.model.Marker;
import com.example.huylv.armanager.util.Util;

import java.util.ArrayList;

/**
 * Created by huylv on 18/02/2016.
 */
public class MarkerListAdapter extends RecyclerView.Adapter<MarkerListAdapter.MarkerViewHolder> {

    ArrayList<Marker> markerArrayList;
    Context context;

    public MarkerListAdapter(Context c, ArrayList<Marker> m){
        markerArrayList=m;
        context=c;
    }

    @Override
    public MarkerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_markerlist, null);

        MarkerViewHolder viewHolder = new MarkerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MarkerViewHolder holder, int position) {
        Marker m = markerArrayList.get(position);
        holder.tvItemMarkerName.setText(m.getName());
    }

    @Override
    public int getItemCount() {
        return markerArrayList.size();
    }

    public class MarkerViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvItemMarkerName;
        Button btItemEdit;
        Button btItemDelete;

        public MarkerViewHolder(View view) {
            super(view);
            this.tvItemMarkerName = (TextView) view.findViewById(R.id.tvItemMarkerName);
            this.btItemEdit = (Button)view.findViewById(R.id.btItemEdit);
            this.btItemDelete = (Button)view.findViewById(R.id.btItemDelete);
        }
    }
}
