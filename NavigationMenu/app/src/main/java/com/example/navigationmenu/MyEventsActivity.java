package com.example.navigationmenu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

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

public class MyEventsActivity extends AppCompatActivity {
    private ArrayList<ExampleEventItems> mEventList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private EventAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private DividerItemDecoration itemDecorator;
    private Bundle mBundleRecyclerViewState;
    private String KEY_RECYCLER_STATE = "save";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_events);

        setTitle("My Events");

        mRecyclerView = findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(new Activity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
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

        /*try {
            XmlPullParserFactory ppf;
            ppf = XmlPullParserFactory.newInstance();
            XmlPullParser parser = ppf.newPullParser();
            AssetManager am = this.getAssets();
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
        }*/

        /*Bundle b = getIntent().getExtras();
        if (b != null) {
            ExampleEventItems event = new ExampleEventItems();
            event.setTitle(b.getString("title"));
            event.setSubtitle(b.getString("organization"));
            event.setDateTime(b.getString("datetime"));
            mEventList.add(event);
        }*/


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
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

        //if (mEventList.size() != 0) {
        //    savedInstanceState.putParcelableArrayList("Events", mEventList);
        //}
    }

    /*@Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        ArrayList<Parcelable> ev = savedInstanceState.getParcelableArrayList("Events");
    }*/
}
