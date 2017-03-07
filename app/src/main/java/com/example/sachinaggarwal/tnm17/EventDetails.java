package com.example.sachinaggarwal.tnm17;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.TextView;


/**
 * Created by Bhavya Sapra on 19-02-2017.
 */

public class EventDetails  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.eventdetails);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        Bundle bundle = getIntent().getExtras();

        String eventcode = bundle.getString("eventcode");
        String eventName = bundle.getString("eventName");
        collapsingToolbarLayout.setTitle(eventName);

        Log.i("eventnameData",eventName);
        Log.i("eventcodeData",eventcode);

        String stringVenue = eventcode+"venue";
        Log.i("stringvalue",stringVenue);
        String venuedata= getStringResourceByName(stringVenue);
        Log.i("venuedata1",venuedata);

        String stringRules = eventcode+"rules";
        String rulesdata= getStringResourceByName(stringRules);

        String stringDescription = eventcode+"description";
        String descriptiondata= getStringResourceByName(stringDescription);

        String stringCoordinators = eventcode+"coordinators";
        String coordinatorsdata= getStringResourceByName(stringCoordinators);

        TextView venueTextView = (TextView) findViewById(R.id.event2);
        venueTextView.setText(venuedata);

        TextView rulesTextView = (TextView) findViewById(R.id.event4);
        rulesTextView.setText(rulesdata);

        TextView descriptionTextView = (TextView) findViewById(R.id.event6);
        descriptionTextView.setText(descriptiondata);

        TextView coordinatorsTextView = (TextView) findViewById(R.id.event8);
        coordinatorsTextView.setText(coordinatorsdata);

    }
    private String getStringResourceByName(String aString)
    {
        String packageName = "com.example.sachinaggarwal.tnm17";
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);

    }
}

