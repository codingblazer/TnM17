package com.example.sachinaggarwal.tnm17.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sachinaggarwal.tnm17.R;

/**
 * Created by HIman$hu on 2/19/2017.
 */

public class Schedule extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        return view;
    }

}