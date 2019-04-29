package com.example.navigationmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MyEventPageActivity extends AppCompatActivity {
    private TextView tVDateTime;
    private TextView tVCost;
    private TextView tVLocation;
    private TextView tVEventType;
    private TextView tVOrganization;
    private TextView tVUrl;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myevent_page);

        tVDateTime = findViewById(R.id.textViewDTLabel);
        tVCost = findViewById(R.id.textViewEvCostLabel);
        tVLocation = findViewById(R.id.textViewEvLocLabel);
        tVEventType = findViewById(R.id.textViewEvTypeLabel);
        tVOrganization = findViewById(R.id.textViewEvOrgLabel);
        tVUrl = findViewById(R.id.textViewEvUrlLabel);

        Intent result = getIntent();
        final String titleResult = result.getExtras().getString("title");
        final String dateTimeResult = result.getExtras().getString("datetime");
        final String costResult = result.getExtras().getString("cost");
        final String locationResult = result.getExtras().getString("location");
        final String eventTypeResult = result.getExtras().getString("eventtype");
        final String orgResult = result.getExtras().getString("organization");
        final String urlResult = result.getExtras().getString("url");

        setTitle(titleResult);
        tVDateTime.setText(dateTimeResult);
        tVCost.setText(costResult);
        tVLocation.setText(locationResult);
        tVEventType.setText(eventTypeResult);
        tVOrganization.setText(orgResult);
        tVUrl.setText(urlResult);
    }

}
