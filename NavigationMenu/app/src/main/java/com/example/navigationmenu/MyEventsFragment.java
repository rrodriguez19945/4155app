package com.example.navigationmenu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class MyEventsFragment extends Fragment{
    ArrayList<ExampleEventItems> mEventList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private EventAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private DividerItemDecoration itemDecorator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_events, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("My Events");

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

        /*EditText editText = v.findViewById(R.id.edittext);
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
        });*/

        /*try {
            XmlPullParserFactory ppf;
            ppf = XmlPullParserFactory.newInstance();
            XmlPullParser parser = ppf.newPullParser();
            AssetManager am = getContext().getAssets();
            InputStream is = am.open("data.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG) {
                    if (parser.getName().equals("item")) {

                        Log.e("MY_VALUE", " * " + parser.getAttributeValue(0) + " * ");
                        Log.e("MY_VALUE", " * " + parser.getAttributeValue(1) + " * ");
                        Log.e("MY_VALUE", " * " + parser.getAttributeValue(2) + " * ");
                        Log.e("MY_VALUE", " * " + parser.getAttributeValue(3) + " * ");
                        Log.e("MY_VALUE", " * " + parser.getAttributeValue(4) + " * ");
                        Log.e("MY_VALUE", " * " + parser.getAttributeValue(5) + " * ");
                        Log.e("MY_VALUE", " * " + parser.getAttributeValue(6) + " * ");
                        Log.e("MY_VALUE", " * " + parser.getAttributeValue(7) + " * ");

                        long num = Long.parseLong(parser.getAttributeValue(2));
                        Date date = new Date(num * 1000L);
                        DateFormat dateTimeFormat = new SimpleDateFormat("MM/dd/yy | hh:mm a");
                        dateTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT-4"));
                        String dateTimeFormatted = dateTimeFormat.format(date);

                        ExampleEventItems event = new ExampleEventItems();
                        event.setId(Integer.parseInt(parser.getAttributeValue(0)));
                        event.setTitle(parser.getAttributeValue(1));
                        event.setDateTime(dateTimeFormatted);
                        event.setCost(parser.getAttributeValue(3));
                        event.setLocation(parser.getAttributeValue(4));
                        event.setEventType(parser.getAttributeValue(5));
                        event.setSubtitle(parser.getAttributeValue(6));
                        event.setUrl(parser.getAttributeValue(7));

                        mEventList.add(event);
                    }
                }
                parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mAdapter.notifyDataSetChanged();*/

        /*((EventPageActivity) getActivity()).passValue(new FragmentCommunicator() {
            @Override
            public void passData(ExampleEventItems event) {
                mEventList.add(event);
            }
        });*/

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        ExampleEventItems event = new ExampleEventItems();
        event.setTitle(prefs.getString("title", "null"));
        event.setDateTime(prefs.getString("datetime", "null"));
        event.setCost(prefs.getString("cost", "null"));
        event.setLocation(prefs.getString("location", "null"));
        event.setEventType(prefs.getString("eventtype", "null"));
        event.setSubtitle(prefs.getString("organization", "null"));
        event.setUrl(prefs.getString("url", "null"));

        mEventList.add(event);

        mAdapter.notifyDataSetChanged();

        return v;
    }


    /*private void filter(String text) {
        ArrayList<ExampleEventItems> filteredList = new ArrayList<>();

        for (ExampleEventItems item : mEventList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase()))
                filteredList.add(item);
            else if (item.getSubTitle().toLowerCase().contains(text.toLowerCase()))
                filteredList.add(item);
        }

        mAdapter.filterList(filteredList);
    }*/
}
