package com.example.sachinaggarwal.tnm17.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sachinaggarwal.tnm17.R;

/**
 * Created by HIman$hu on 4/6/2017.
 */

public class DeveloperAdapter extends ArrayAdapter<String> {

    private LayoutInflater mInflater;
    private final Context context;
    Bitmap[] pics;
    String[] contri;
    int t = -1;

    public DeveloperAdapter(Context context, String[] item, Bitmap[] pics, String[] contri) {
        super(context, R.layout.custom_developers, item);
        this.context = context;
        this.pics = pics;
        this.contri = contri;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String str = getItem(position);
        final Holder holder;

        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.home_fade);

        if (convertView == null) {
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_developers, parent, false);
            holder = new Holder();
            holder.DevImage = (ImageView) convertView.findViewById(R.id.DevImage);
            holder.DevName = (TextView) convertView.findViewById(R.id.DevName);
            holder.contri = (TextView) convertView.findViewById(R.id.contri);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }


        try {
            holder.contri.setText(contri[position]);
            holder.DevImage.setImageBitmap(pics[position]);
            holder.DevName.setText(str);

        } catch (NullPointerException e) {
            Log.d("Results", "Results is opened");
        }


        if (t < position)
            convertView.startAnimation(anim);

        t = position;
        return convertView;
    }


    public class Holder {
        public TextView DevName;
        public ImageView DevImage;
        public TextView contri;
    }
}
