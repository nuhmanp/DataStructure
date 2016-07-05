package com.example.nparamban2595.datastructure;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nparamban2595 on 7/5/2016.
 */
public class CustomAdapter  extends ArrayAdapter<String> {
    private final String[] strList;
    private final Activity intents;
    private final Integer[] imgid;

    public CustomAdapter(Activity context, String[] strList, Integer[] imgid) {
        super(context, R.layout.my_list_view, strList);
        // TODO Auto-generated constructor stub

        this.intents=context;
        this.strList=strList;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=intents.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.my_list_view, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(strList[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description "+strList[position]);
        return rowView;

    };
}