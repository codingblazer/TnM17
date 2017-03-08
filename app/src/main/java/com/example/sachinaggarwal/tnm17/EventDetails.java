package com.example.sachinaggarwal.tnm17;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;


/**
 * Created by Bhavya Sapra on 19-02-2017.
 */

public class EventDetails  extends AppCompatActivity {
    Button backbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.eventdetails);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        Bundle bundle = getIntent().getExtras();

        String eventcode = bundle.getString("eventcode");
        String eventName = bundle.getString("eventName");
//        collapsingToolbarLayout.setTitle("EVENT");


        backbutton2 = (Button) findViewById(R.id.backbutton2);
        backbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setRefreshToolbarEnable(collapsingToolbarLayout,true);
//        collapsingToolbarLayout.setTitleEnabled(true);
        collapsingToolbarLayout.setTitle(eventName);
        Log.i("eventnameData", eventName);
        Log.i("eventcodeData", eventcode);


        String stringVenue = eventcode + "venue";
        Log.i("stringvalue", stringVenue);
        String venuedata = getStringResourceByName(stringVenue);
        Log.i("venuedata1", venuedata);

        String stringRules = eventcode + "rules";
        String rulesdata = getStringResourceByName(stringRules);

        String stringDescription = eventcode + "description";
        String descriptiondata = getStringResourceByName(stringDescription);

        String stringCoordinators = eventcode + "coordinators";
        String coordinatorsdata = getStringResourceByName(stringCoordinators);

        TextView venueTextView = (TextView) findViewById(R.id.event2);
        venueTextView.setText(venuedata);

        TextView rulesTextView = (TextView) findViewById(R.id.event4);
        rulesTextView.setText(rulesdata);

        TextView descriptionTextView = (TextView) findViewById(R.id.event6);
        descriptionTextView.setText(descriptiondata);

        TextView coordinatorsTextView = (TextView) findViewById(R.id.event8);
        coordinatorsTextView.setText(coordinatorsdata);

    }

    private String getStringResourceByName(String aString) {
        String packageName = "com.example.sachinaggarwal.tnm17";
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);

    }

    public static void setRefreshToolbarEnable(CollapsingToolbarLayout collapsingToolbarLayout,
                                               boolean refreshToolbarEnable) {
        try {
            Field field = CollapsingToolbarLayout.class.getDeclaredField("mRefreshToolbar");
            field.setAccessible(true);
            field.setBoolean(collapsingToolbarLayout, refreshToolbarEnable);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
