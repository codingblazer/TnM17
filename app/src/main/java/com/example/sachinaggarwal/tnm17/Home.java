package com.example.sachinaggarwal.tnm17;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sachinaggarwal.tnm17.Fragments.ContactUs;
import com.example.sachinaggarwal.tnm17.Fragments.Developers;
import com.example.sachinaggarwal.tnm17.Fragments.Events;
import com.example.sachinaggarwal.tnm17.Fragments.Favourite;
import com.example.sachinaggarwal.tnm17.Fragments.HomeFragment;
import com.example.sachinaggarwal.tnm17.Fragments.MapFragment;
import com.example.sachinaggarwal.tnm17.Fragments.Schedule;
import com.example.sachinaggarwal.tnm17.Fragments.SearchResults;
import com.example.sachinaggarwal.tnm17.Fragments.Sponsors;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    boolean exit = false;
    Fragment fragment = null;
    Fragment lastFragment = null;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView nvDrawer;

    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private boolean searchResultShowing = false;
    EditText edtSeach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                exit = false;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                exit = false;
            }
        };


        drawer.setDrawerListener(toggle);
        toggle.syncState();


        nvDrawer = (NavigationView) findViewById(R.id.nav_view);
        nvDrawer.setNavigationItemSelectedListener(this);

        fragment = new Favourite();

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.Home:
                lastFragment = new HomeFragment();
                fragment = new HomeFragment();
                break;

            case R.id.events:
//                lastFragment = new Events();
//                fragment = new Events();
                Intent intent=new Intent(this,Events.class);
                startActivity(intent);
                break;

            case R.id.schedule:
                Intent intent2=new Intent(this,Schedule.class);
                startActivity(intent2);
//                lastFragment = new Schedule();
//                fragment = new Schedule();
                break;

            case R.id.favourites:
                lastFragment = new Favourite();
                fragment = new Favourite();
                break;

            case R.id.map:
                lastFragment = new MapFragment();
                fragment = new MapFragment();
                break;

            case R.id.sponsors:
                lastFragment = new Sponsors();
                fragment = new Sponsors();
                break;

            case R.id.contact_us:
                lastFragment = new ContactUs();
                fragment = new ContactUs();
                break;

            case R.id.developers:
                lastFragment = new Developers();
                fragment = new Developers();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (fragment != null) {
            item.setChecked(true);
            toolbar.setTitle(item.getTitle());
        }


        drawer.closeDrawer(GravityCompat.START);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (fragment != null) {
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
                }
            }
        }, 380);

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                handleMenuSearch();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void handleMenuSearch() {
        ActionBar action = getSupportActionBar(); //get the actionbar

        if (isSearchOpened) { //test if the search is open

            action.setDisplayShowCustomEnabled(false); //disable a custom view inside the actionbar
            action.setDisplayShowTitleEnabled(true); //show the title in the action bar

            //hides the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtSeach.getWindowToken(), 0);

            //add the search icon in the action bar
            mSearchAction.setIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_menu_search));

            isSearchOpened = false;
        } else { //open the search entry

            action.setDisplayShowCustomEnabled(true); //enable it to display a
            // custom view in the action bar.
            action.setCustomView(R.layout.search_bar);//add the custom view
            action.setDisplayShowTitleEnabled(false); //hide the title

            edtSeach = (EditText) action.getCustomView().findViewById(R.id.edtSearch); //the text editor

            //this is a listener to do a search when the user clicks on search button
            edtSeach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        doSearch();
                        return true;
                    }
                    return false;
                }
            });


            edtSeach.requestFocus();

            //open the keyboard focused in the edtSearch
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edtSeach, InputMethodManager.SHOW_IMPLICIT);


            //add the close icon
            mSearchAction.setIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_close_search));

            isSearchOpened = true;
        }
    }

    public void doSearch() {
        Log.d("Success", "doSearch");

        fragment = new SearchResults();
        //Passing data to the fragment
        Bundle args = new Bundle();
        args.putString("key", edtSeach.getText().toString());
        fragment.setArguments(args);

        if (fragment != null) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            searchResultShowing = true;
        }
    }
}
