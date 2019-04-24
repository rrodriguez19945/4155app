package com.example.navigationmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EventPageActivity extends AppCompatActivity {
    private TextView tVTitle;
    private TextView tvOrganization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);

        tVTitle = findViewById(R.id.textViewEvTitle);
        tvOrganization = findViewById(R.id.textViewEvOrgLabel);

        Intent result = getIntent();

        String titleResult = result.getExtras().getString("title");
        String orgResult = result.getExtras().getString("organization");

        tVTitle.setText(titleResult);
        tvOrganization.setText(orgResult);

    }




}
