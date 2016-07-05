package com.example.nparamban2595.datastructure;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nparamban2595 on 7/5/2016.
 * Custom adapter for holding image and textview
 */
public class CustomAdapter  extends ArrayAdapter<String> {
    //Delclare string array
    private final String[] strList;
    //declare intent
    private final Activity intents;
    //Declare array of images
    private final Integer[] imgid;
    //Arraylist to get description of items
    ArrayList<MainActivity.Element> mItems;
    //Custom adapter constructor
    public CustomAdapter(Activity context, String[] strList, Integer[] imgid,ArrayList<MainActivity.Element> mItems) {
        super(context, R.layout.my_list_view, strList);
        // setting context, string array list and image id's

        this.intents=context;
        this.strList=strList;
        this.imgid=imgid;
        this.mItems = mItems;
    }
    //getting view
    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=intents.getLayoutInflater();
        //instantiating a layout XML file into its corresponding views
        View rowView=inflater.inflate(R.layout.my_list_view, null,true);
        //getting title textview from xml
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        //getting image view from xml
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        //getting description textview from xml
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        //set title
        txtTitle.setText(strList[position]);
        //get and set image
        imageView.setImageResource(imgid[position]);
        //get and set description
        extratxt.setText(mItems.get(position).getmDesc());
        //return view
        return rowView;

    };
}