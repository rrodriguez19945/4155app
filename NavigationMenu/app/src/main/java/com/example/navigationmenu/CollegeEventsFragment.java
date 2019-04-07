package com.example.navigationmenu;

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

import java.util.ArrayList;

public class CollegeEventsFragment extends Fragment {
    private ArrayList<ExampleEventItems> mEventList;
    private RecyclerView mRecyclerView;
    private EventAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private DividerItemDecoration itemDecorator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_college_events, container, false);

        createExampleList();

        mRecyclerView = v.findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider));
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new EventAdapter(mEventList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListener(new EventAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mEventList.get(position);
            }
        });

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

        return v;
    }

    private void filter(String text) {
        ArrayList<ExampleEventItems> filteredList = new ArrayList<>();

        for (ExampleEventItems item : mEventList){
            if (item.getText1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        mEventList = new ArrayList<>();
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Cat", "Line 2"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Dog", "Line 4"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Apple", "Line 6"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Lion", "Line 8"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Crow", "Line 2"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 3", "Line 4"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 5", "Line 6"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 7", "Line 8"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 1", "Line 2"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 3", "Line 4"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 5", "Line 6"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 7", "Line 8"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 1", "Line 2"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 3", "Line 4"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 5", "Line 6"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 7", "Line 8"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 1", "Line 2"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 3", "Line 4"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 5", "Line 6"));
        mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Line 7", "Line 8"));
    }
}
