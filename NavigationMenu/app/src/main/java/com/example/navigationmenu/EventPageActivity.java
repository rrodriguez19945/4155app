package com.example.navigationmenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventPageActivity extends AppCompatActivity {
    private TextView tVDateTime;
    private TextView tVCost;
    private TextView tVLocation;
    private TextView tVEventType;
    private TextView tVOrganization;
    private TextView tVUrl;
    private Button btnSave;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);

        tVDateTime = findViewById(R.id.textViewDTLabel);
        tVCost = findViewById(R.id.textViewEvCostLabel);
        tVLocation = findViewById(R.id.textViewEvLocLabel);
        tVEventType = findViewById(R.id.textViewEvTypeLabel);
        tVOrganization = findViewById(R.id.textViewEvOrgLabel);
        tVUrl = findViewById(R.id.textViewEvUrlLabel);
        btnSave = findViewById(R.id.buttonSaveEv);

        Intent result = getIntent();
        final int id = result.getExtras().getInt("id");
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

        /*eventItem.setTitle(titleResult);
        eventItem.setDateTime(dateTimeResult);
        eventItem.setCost(costResult);
        eventItem.setLocation(locationResult);
        eventItem.setEventType(eventTypeResult);
        eventItem.setSubtitle(orgResult);
        eventItem.setUrl(urlResult);

        event.add(eventItem);*/

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean addEvent = false;
                ExampleEventItems event = new ExampleEventItems();
                for (ExampleEventItems savedEvent : Singleton.getInstance().getArrayList()) {
                    if (event.getTitle().equals(titleResult))
                        addEvent = true;
                }
                if (addEvent != true) {
                    event.setId(id);
                    event.setTitle(titleResult);
                    event.setDateTime(dateTimeResult);
                    event.setCost(costResult);
                    event.setLocation(locationResult);
                    event.setEventType(eventTypeResult);
                    event.setSubtitle(orgResult);
                    event.setUrl(urlResult);
                    Singleton.getInstance().getArrayList().add(event);
                    showMessage("Event saved.");
                }
                else
                    showMessage("Event already saved.");

            }
        });
    }

    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
