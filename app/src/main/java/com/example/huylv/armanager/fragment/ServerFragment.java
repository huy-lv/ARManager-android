package com.example.huylv.armanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.huylv.armanager.R;
import com.example.huylv.armanager.adapter.ServerMarkerAdapter;
import com.example.huylv.armanager.model.ServerMarker;
import com.example.huylv.armanager.network.ServiceBuilder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by huylv on 23-Feb-16.
 */
public class ServerFragment extends Fragment {

    @Bind(R.id.pbServerMarker)
    ProgressBar pbServerMarker;

    @Bind(R.id.rvServerMarkerList)
    RecyclerView rvServerMarkerList;
    ServerMarkerAdapter adapter;
    ArrayList<ServerMarker> serverMarkerArrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_server, container, false);
        ButterKnife.bind(this, v);

        serverMarkerArrayList = new ArrayList<>();

        fetchFromServer();

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvServerMarkerList.setLayoutManager(llm);
        adapter = new ServerMarkerAdapter(getActivity(), serverMarkerArrayList);
        rvServerMarkerList.setAdapter(adapter);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btServerRefresh)
    void fetchFromServer() {

        pbServerMarker.setVisibility(View.VISIBLE);
        rvServerMarkerList.setVisibility(View.GONE);

        Call<ServerMarker[]> call = ServiceBuilder.getService().getAllMarker();
        call.enqueue(new Callback<ServerMarker[]>() {
            @Override
            public void onResponse(Call<ServerMarker[]> call, Response<ServerMarker[]> response) {
                if (response.isSuccess()) {
                    ServerMarker[] markerList = response.body();
                    serverMarkerArrayList.clear();
                    for (ServerMarker m : markerList) {
                        serverMarkerArrayList.add(m);
                    }
                    adapter.notifyDataSetChanged();

                    pbServerMarker.setVisibility(View.GONE);
                    rvServerMarkerList.setVisibility(View.VISIBLE);
                } else {
                    Log.e("cxz", "error:" + response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<ServerMarker[]> call, Throwable t) {
                Log.e("cxz", "failure:" + t.getMessage());
            }
        });

    }

}
