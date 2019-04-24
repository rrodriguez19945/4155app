package com.example.navigationmenu;

import android.content.res.AssetManager;
import android.os.Bundle;
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

public class CollegeEventsFragment extends Fragment {
    ArrayList<ExampleEventItems> mEventList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private EventAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private DividerItemDecoration itemDecorator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_college_events, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("College Events");

        //createExampleList();

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

        //parseXML();

        try {
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
                        //event.setCost(parser.getAttributeValue(3));
                        event.setSubtitle(parser.getAttributeValue(6));
                        event.setDateTime(dateTimeFormatted);

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

        mAdapter.notifyDataSetChanged();

        return v;
    }

    private void filter(String text) {
        ArrayList<ExampleEventItems> filteredList = new ArrayList<>();

        for (ExampleEventItems item : mEventList){
            if (item.getTitle().toLowerCase().contains(text.toLowerCase()))
                filteredList.add(item);
            else if (item.getSubTitle().toLowerCase().contains(text.toLowerCase()))
                filteredList.add(item);
        }

        mAdapter.filterList(filteredList);
    }



    /*private void parseXML() {
        XmlPullParserFactory ppf;
        AssetManager am = getContext().getAssets();
        try {
            ppf = XmlPullParserFactory.newInstance();
            XmlPullParser parser = ppf.newPullParser();
            InputStream is = am.open("data.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /*private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException{
        ArrayList<ExampleEventItems> events = null;
        int eventType = parser.getEventType();
        ExampleEventItems currentEvent = null;


        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    if("item".equals(eltName)) {
                        currentEvent = new ExampleEventItems();
                        events.add(currentEvent);
                    } else if (currentEvent != null) {
                        if ("title".equals(eltName)) {
                            currentEvent.mText1 = parser.nextText();
                        }
                        else if ("organization".equals(eltName)) {
                            currentEvent.mText2 = parser.nextText();
                        }
                    }
                    break;
            }
            eventType = parser.next();
        }
        displayEvents(events);

    }*/

    /*private void displayEvents(ArrayList<ExampleEventItems> events) {
        mEventList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mEventList.add(new ExampleEventItems(R.drawable.ic_smily, events.get(i).mText1, events.get(i).mText2));

        }


    }*/

    /*private void createExampleList() {
        mEventList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            mEventList.add(new ExampleEventItems(R.drawable.ic_smily, "Cat", "Line 2"));
        }



    }
    */
}
