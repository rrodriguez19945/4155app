package com.example.navigationmenu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private ArrayList<ExampleEventItems> mEventList = new ArrayList<>();
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewTitle;
        public TextView mTextViewSubtitle;
        public TextView mTextViewDateTime;

        public EventViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextViewTitle = itemView.findViewById(R.id.textViewTitle);
            mTextViewSubtitle = itemView.findViewById(R.id.textViewSubtitle);
            mTextViewDateTime = itemView.findViewById(R.id.textViewDateTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                            listener.onItemClick(position);*/
                    Context c = v.getContext();
                    Intent i = new Intent(c, EventPageActivity.class);
                    c.startActivity(i);

                }
            });
        }

    }

    public EventAdapter(ArrayList<ExampleEventItems> eventList) {
        mEventList = eventList;


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
        eventViewHolder.mTextViewSubtitle.setText(currentItem.getSubTitle());
        eventViewHolder.mTextViewDateTime.setText(currentItem.getDateTime());

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
