package com.example.navigationmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CollegeEventsFragment extends Fragment {
    private ArrayList<ExampleEventItems> mEventList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_college_events, container, false);
        RecyclerView mRecyclerView;
        EventAdapter mAdapter;
        LinearLayoutManager mLinearLayoutManager;
        DividerItemDecoration itemDecorator;

        EditText editText = v.findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        private void filter(String text) {
            ArrayList<ExampleEventItems> filteredList = new ArrayList<>();

            for (ExampleEventItems item : mEventList) {
                if (item.getText1().toLowerCase().contains(text.toL))
            }
        }

        ArrayList<ExampleEventItems> eventList = new ArrayList<>();
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 1", "Line 2"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 3", "Line 4"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 5", "Line 6"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 7", "Line 8"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 1", "Line 2"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 3", "Line 4"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 5", "Line 6"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 7", "Line 8"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 1", "Line 2"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 3", "Line 4"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 5", "Line 6"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 7", "Line 8"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 1", "Line 2"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 3", "Line 4"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 5", "Line 6"));
        eventList.add(new ExampleEventItems(R.drawable.ic_sentiment_satisfied_black_24dp, "Line 7", "Line 8"));

        mRecyclerView = v.findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider));
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new EventAdapter(eventList);
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
