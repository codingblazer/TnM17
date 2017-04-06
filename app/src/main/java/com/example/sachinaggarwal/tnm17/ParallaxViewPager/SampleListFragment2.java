package com.example.sachinaggarwal.tnm17.ParallaxViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.sachinaggarwal.tnm17.EventDetails;
import com.example.sachinaggarwal.tnm17.Fragments.Schedule;
import com.example.sachinaggarwal.tnm17.R;

import java.util.ArrayList;

/**
 * Created by Bhavya Sapra on 20-02-2017.
 */
public class SampleListFragment2 extends ScrollTabHolderFragment {

    private static final String ARG_POSITION = "position";

    //<<<<<<< HEAD
    private ListView mListView;
    //    private SwipeMenuListView mList;
//        private ArrayList<String> mListItems;
//
//    private int mPosition;
//
//    String[] events_1;
//    int[] images;
//    String[] timing;
//    String[] intents;
//    TextView eventName, act_name;
//
//=======
    //    private ListView mListView;
    private SwipeMenuListView mList;
    private ArrayList<String> mListItems;

    private int mPosition;

    //>>>>>>> parallax package
    public static Fragment newInstance(int position) {
        SampleListFragment2 f = new SampleListFragment2();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments().getInt(ARG_POSITION);
//
//<<<<<<< HEAD
        mListItems = new ArrayList<String>();


        if(mPosition==0) {
            mListItems.add("Be Like Nolan");
            mListItems.add("Be You");
            mListItems.add("Let’s QuizUp");
            mListItems.add("Pixelate");
            mListItems.add("Contrast");
            mListItems.add(
                    "Directors Cut");
        }
        else if(mPosition==1){
            mListItems.add("Reverse Coding");
            mListItems.add("Web Design");
            mListItems.add("Appathon");
            mListItems.add("HackMait");
            mListItems.add("Blind-Coding");
            mListItems.add(
                    "TechShowdown");



        }
        else if(mPosition==2){
            mListItems.add("Pool (9 Ball)");
            mListItems.add("KHEL KABADDI (Boys Only)");
            mListItems.add("Arm wrestling");
            mListItems.add("Galli Cricket");
            mListItems.add("TUG OF WAR");
            mListItems.add("Carrom");



        }
        else if(mPosition==3){
            mListItems.add("Vincero");
            mListItems.add(
                    "JAM Charades");
            mListItems.add(
                    "Ardor");
            mListItems.add(
                    "Spin-A- Yarn");
            mListItems.add(
                    "Conundrum");


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_list, null);

        mListView = (ListView) v.findViewById(R.id.listView);

        View v1 = inflater.inflate(R.layout.schedule_list, null);

        mList = (SwipeMenuListView) v1.findViewById(R.id.schedule_categories_listView);

        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(getContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xf4, 0x43, 0x36)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(getContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0x28,
                        0x28, 0x28)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_settings);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        View placeHolderView = inflater.inflate(R.layout.view_header_placeholder, mListView, false);
        placeHolderView.setBackgroundColor(0xFFFFFFFF);
        mListView.addHeaderView(placeHolderView);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListView.setOnScrollListener(new OnScroll());
        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, android.R.id.text1, mListItems));

        if(mPosition==0){

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent1;
                intent1=new Intent(getContext(),EventDetails.class);

                intent1.putExtra("eventcode","CL"+ (position-1));
                intent1.putExtra("eventName",mListItems.get(position-1));
                startActivity(intent1);
            }
        });
        }

        else if(mPosition==1){
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Intent intent1;
                    intent1=new Intent(getContext(),EventDetails.class);
                    intent1.putExtra("eventcode","TS"+ (position-1));
                    intent1.putExtra("eventName",mListItems.get(position-1));
                    startActivity(intent1);
                }
            });
        }

        else if(mPosition==2){
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Intent intent1;
                    intent1=new Intent(getContext(),EventDetails.class);
                    intent1.putExtra("eventcode","NT"+ (position-1));
                    intent1.putExtra("eventName",mListItems.get(position-1));
                    startActivity(intent1);
                }
            });
        }

        else if(mPosition==3){
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Intent intent1;
                    intent1=new Intent(getContext(),EventDetails.class);
                    intent1.putExtra("eventcode","LR"+ (position-1));
                    intent1.putExtra("eventName",mListItems.get(position-1));
                    startActivity(intent1);
                }
            });
        }
        else if(mPosition==4){
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Intent intent1;
                    intent1=new Intent(getContext(),EventDetails.class);
                    intent1.putExtra("eventcode","LR"+ (position-1));
                    intent1.putExtra("eventName",mListItems.get(position-1));
                    startActivity(intent1);
                }
            });
        }



//<<<<<<< HEAD
//        if(Schedule.NEEDS_PROXY){//in my moto phone(android 2.1),setOnScrollListener do not work well
//=======
        Log.i("OnTouch","dsfdsfdsfds");

        if (Schedule.NEEDS_PROXY) {//in my moto phone(android 2.1),setOnScrollListener do not work well
//>>>>>>> parallax package
            mListView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (mScrollTabHolder != null)
                        mScrollTabHolder.onScroll(mListView, 0, 0, 0, mPosition);
                    return false;
                }
            });
        }
    }

    @Override
    public void adjustScroll(int scrollHeight) {
        if (scrollHeight == 0 && mListView.getFirstVisiblePosition() >= 1) {
            return;
        }

        mListView.setSelectionFromTop(1, scrollHeight);

    }


    class OnScroll implements AbsListView.OnScrollListener {

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem,
                             int visibleItemCount, int totalItemCount) {
            if (mScrollTabHolder != null)
                mScrollTabHolder.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount, mPosition);
        }

    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount, int pagePosition) {
    }


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.schedule_list, null);
//
//        mList = (SwipeMenuListView) v.findViewById(R.id.schedule_categories_listView);
//
//        // step 1. create a MenuCreator
//        SwipeMenuCreator creator = new SwipeMenuCreator() {
//
//            @Override
//            public void create(SwipeMenu menu) {
//                // create "open" item
//                SwipeMenuItem openItem = new SwipeMenuItem(getContext());
//                // set item background
//                openItem.setBackground(new ColorDrawable(Color.rgb(0xf4, 0x43, 0x36)));
//                // set item width
//                openItem.setWidth(dp2px(90));
//                // set item title
//                openItem.setTitle("Open");
//                // set item title fontsize
//                openItem.setTitleSize(18);
//                // set item title font color
//                openItem.setTitleColor(Color.WHITE);
//                // add to menu
//                menu.addMenuItem(openItem);
//
//                // create "delete" item
//                SwipeMenuItem deleteItem = new SwipeMenuItem(getContext());
//                // set item background
//                deleteItem.setBackground(new ColorDrawable(Color.rgb(0x28,
//                        0x28, 0x28)));
//                // set item width
//                deleteItem.setWidth(dp2px(90));
//                // set a icon
//                deleteItem.setIcon(R.drawable.ic_settings);
//                // add to menu
//                menu.addMenuItem(deleteItem);
//            }
//        };
//
////        View placeHolderView = inflater.inflate(R.layout.view_header_placeholder, mListView, false);
////        placeHolderView.setBackgroundColor(0xFFFFFFFF);
////        mListView.addHeaderView(placeHolderView);
//
//        // set creator
//        mList.setMenuCreator(creator);
//        mList.setOpenInterpolator(new BounceInterpolator());
//        mList.setCloseInterpolator(new BounceInterpolator());
//
//
//        //Add events in this array
//        events_1 = new String[]{"Alkhwarizm", "Blind War", "C Fresh", "C Hunt", "C Master", "Ex-Machina", "Humble Fool Cup", "Infinitum", "Three Muskeeters"};
//
//        images = new int[]{R.drawable.alkhwarizm, R.drawable.blindwar, R.drawable.cfresh, R.drawable.chunt, R.drawable.exmachina, R.drawable.humblefool};
//
//        timing = new String[]{"6:00 PM, CC3", "6:00 PM, CC3", "2:00 PM - 6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3"};
//
//        intents = new String[]{"ALK", "BLI", "CFR", "CHU", "CMA", "EXM", "HUM", "INF", "THR"};
//
//        initList(events_1, images, timing, intents);
//
//        return v;
//    }
//
//    public void initList(String[] eventsArray, int[] imagesList, String[] timingList, String[] intentsList) {
//        if (eventsArray.length != 0) {
//
//            ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();
//
//            for (int i = 0; i < eventsArray.length; i++) {
//                HashMap<String, String> candy = new HashMap<String, String>();
//                candy.put("event", eventsArray[i]);
//                candy.put("image", Integer.toString(imagesList[i]));
//                candy.put("time", timingList[i]);
//                candy.put("intent", "com.app.aparoksha.apro16." + intentsList[i].trim());
//                eventList.add(candy);
//            }
//
//            ListAdapter adapter = new SimpleAdapter(
//                    getContext(),
//                    eventList,
//                    R.layout.schedule_list_item,
//                    new String[]{"event", "image", "time", "intent"},
//                    new int[]{R.id.event_name, R.id.eventImg, R.id.eventTime, R.id.intent}) {
//                @Override
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    View view = super.getView(position, convertView, parent);
//                    TextView item_name = (TextView) view.findViewById(R.id.event_name);
//                    return view;
//                }
//            };
//
//            mList.setAdapter(adapter);
//        }
//
//        mList.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
//                switch (index) {
//                    case 0:
//                        // open
//
//                        String intentToOpen = "com.app.aparoksha.apro16." + intents[position];
//
//                        Intent i = new Intent(intentToOpen);
//                        i.putExtra("INTENT", intentToOpen);
//                        startActivity(i);
//
//                        break;
//                    case 1:
//                        Intent it = new Intent("com.app.aparoksha.apro16.SN");
//                        it.putExtra("event", events_1[position]);
//                        it.putExtra("address", "com.app.aparoksha.apro16." + intents[position]);
//                        startActivity(it);
//                        break;
//                }
//                return false;
//            }
//        });
//
//    }
//
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
////        mListView.setOnScrollListener(new OnScroll());
////        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, android.R.id.text1, mListItems));
////
////        if (Schedule.NEEDS_PROXY) {//in my moto phone(android 2.1),setOnScrollListener do not work well
////            mListView.setOnTouchListener(new OnTouchListener() {
////                @Override
////                public boolean onTouch(View v, MotionEvent event) {
////                    if (mScrollTabHolder != null)
////                        mScrollTabHolder.onScroll(mListView, 0, 0, 0, mPosition);
////                    return false;
////                }
////            });
////        }
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void adjustScroll(int scrollHeight) {
//        if (scrollHeight == 0 && mList.getFirstVisiblePosition() >= 1) {
//            return;
//        }
//
//        mList.setSelectionFromTop(1, scrollHeight);
//
//    }
//
//    public class OnScroll implements OnScrollListener {
//
//        @Override
//        public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//        }
//
//        @Override
//        public void onScroll(AbsListView view, int firstVisibleItem,
//                             int visibleItemCount, int totalItemCount) {
//            if (mScrollTabHolder != null)
//                mScrollTabHolder.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount, mPosition);
//        }
//
//    }
//
//
//    @Override
//    public void onScroll(AbsListView view, int firstVisibleItem,
//                         int visibleItemCount, int totalItemCount, int pagePosition) {
//    }


}