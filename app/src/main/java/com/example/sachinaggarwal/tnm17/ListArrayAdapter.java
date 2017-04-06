package com.example.sachinaggarwal.tnm17;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bhavya Sapra on 18-03-2017.
 */

public class ListArrayAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> itemsName;


    public ListArrayAdapter(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
        this.context = context;
        itemsName = objects;
    }

    public static class ViewHolder{
        TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(context,R.layout.list_item_layout,null);
            TextView textView1 = (TextView) convertView.findViewById(R.id.leftTextView);
            ViewHolder vh = new ViewHolder();
            vh.textView= textView1;
            ;

            convertView.setTag(vh);
        }

        ViewHolder vh = (ViewHolder)convertView.getTag();
        vh.textView.setText(itemsName.get(position));

        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}
