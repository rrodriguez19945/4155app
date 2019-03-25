package com.example.navigationmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

public class CollegeEventsFragment extends Fragment {
    private ArrayList<ExampleEventItems> mEventList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_college_events, container, false);
        RecyclerView mRecyclerView;
        EventAdapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;


        ArrayList<ExampleEventItems> eventList = new ArrayList<>();
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 1", "Line 2"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 3", "Line 4"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 5", "Line 6"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 7", "Line 8"));

        mRecyclerView = v.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new EventAdapter(eventList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListener(new EventAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mEventList.get(position);
            }
        });

        return v;
    }


}
