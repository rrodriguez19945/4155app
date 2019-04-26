package com.example.navigationmenu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private static ArrayList<ExampleEventItems> mEventList;
    private static OnItemClickListener mListener;

    public EventAdapter(ArrayList<ExampleEventItems> mEventList) {
        this.mEventList = mEventList;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewTitle;
        public TextView mTextViewDateTime;
        public TextView mCost;
        public TextView mLocation;
        public TextView mEventType;
        public TextView mTextViewSubtitle;
        public TextView mUrl;

        public EventViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextViewTitle = itemView.findViewById(R.id.textViewTitle);
            mTextViewDateTime = itemView.findViewById(R.id.textViewDateTime);
            mCost = itemView.findViewById(R.id.textViewEvCostLabel);
            mLocation = itemView.findViewById(R.id.textViewEvLocLabel);
            mEventType = itemView.findViewById(R.id.textViewEvTypeLabel);
            mTextViewSubtitle = itemView.findViewById(R.id.textViewSubtitle);
            mUrl = itemView.findViewById(R.id.textViewEvUrlLabel);

            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context c = v.getContext();
                    Intent i = new Intent(c, EventPageActivity.class);
                    i.putExtra("title", mTextViewTitle.getText().toString());
                    i.putExtra("datetime", mTextViewDateTime.getText().toString());
                    i.putExtra("cost", mEventList.get(getLayoutPosition()).getCost());
                    i.putExtra("location", mEventList.get(getLayoutPosition()).getLocation());
                    i.putExtra("eventtype", mEventList.get(getLayoutPosition()).getEventType());
                    i.putExtra("organization", mTextViewSubtitle.getText().toString());
                    i.putExtra("url", mEventList.get(getLayoutPosition()).getUrl());
                    c.startActivity(i);
                }
            });
        }
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.college_event_items, viewGroup, false);
        EventViewHolder evh = new EventViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int i) {
        ExampleEventItems currentItem = mEventList.get(i);

        eventViewHolder.mImageView.setImageResource(currentItem.getImageResource());
        eventViewHolder.mTextViewTitle.setText(currentItem.getTitle());
        eventViewHolder.mTextViewDateTime.setText(currentItem.getDateTime());
        eventViewHolder.mTextViewSubtitle.setText(currentItem.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    public void filterList(ArrayList<ExampleEventItems> filteredList) {
        mEventList = filteredList;
        notifyDataSetChanged();
    }
}
