package com.app.sample.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.news.ActivityChannelDetails;
import com.app.sample.news.ActivityMain;
import com.app.sample.news.R;
import com.app.sample.news.adapter.AdapterChannelList;
import com.app.sample.news.data.Constant;
import com.app.sample.news.model.Channel;

public class FragmentChannel extends Fragment{

    private View root_view;
    private RecyclerView recyclerView;
    private AdapterChannelList mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.fragment_channel, null);

        recyclerView = (RecyclerView) root_view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        //set data and list adapter
        mAdapter = new AdapterChannelList(getActivity(), Constant.getChannelData(getActivity()));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new AdapterChannelList.OnItemClickListener() {
            @Override
            public void onItemClick(View v, Channel obj, int position) {
                ActivityChannelDetails.navigate((ActivityMain)getActivity(), v, obj);
            }
        });
        return root_view;
    }

    @Override
    public void onResume() {
        mAdapter.notifyDataSetChanged();
        super.onResume();
    }
}
