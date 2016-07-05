package com.example.nparamban2595.datastructure;
/**
 * Main Class for data structure
 *
 */

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    //declare list view element
    ListView list;
    //declare an arraylist of Elements to store description of list item
    ArrayList<Element> mItems;

    //create an array of names for display
    String[] listNames ={ "BBC SPORT","SONY SIX", "FOX SPORTS","SKY SPORTS", "STAR SPORTS 2","STAR SPORTS", "STAR SPORTS","ESPN"};

    //create an array of images to display
    Integer[] imgid={ R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //store description and id in custom element display class object
        mItems = new ArrayList<MainActivity.Element>();
        mItems.add(new Element("FIFA WORLD CUP", 1));
        mItems.add(new Element("WWE FINAL", 2));
        mItems.add(new Element("CRICKET IND VS AUS", 3));
        mItems.add(new Element("ICE HOCKEY LIVE", 4));
        mItems.add(new Element("RUGBY CAN VS USA", 5));
        mItems.add(new Element("GOLF TURF", 6));
        mItems.add(new Element("SPORTS TIME", 7));
        mItems.add(new Element("SPORTS NEWS", 8));

        //declare and initialize custom adapter
        CustomAdapter adapter=new CustomAdapter(this, listNames, imgid, mItems);
        //find listview element
        list=(ListView)findViewById(R.id.sampleListView);
        //setting custom adapter to main activity
        list.setAdapter(adapter);
        //set on item click listener for list
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //getting selected item based on position
                String Slecteditem= listNames[+position];
                //Show item as a toas
                Toast.makeText(getApplicationContext(), "You are in "+Slecteditem, Toast.LENGTH_SHORT).show();

                //create a new intent of custom display for a particular list item
                Intent intent = new Intent(MainActivity.this,CustomDisplay.class);
                //start new intent
                startActivity(intent);


            }
        });
    }
    public static class Element {
        private String mText;
        private int mId;
        private String mDesc;
        private Integer mImg;


        public Element(String text,String desc, Integer img, int id) {
            mText = text;
            mId = id;
            mDesc=desc;
            mImg = img;
        }
        public Element(String desc, int id) {
            mDesc=desc;
            mId = id;
        }

        public int getId() {
            return mId;
        }

        public void setId(int id) {
            mId = id;
        }

        public String getmText() {
            return mText;
        }

        public void setmText(String mText) {
            this.mText = mText;
        }

        @Override
        public String toString() {
            return mText;
        }

        public String getmDesc() {
            return mDesc;
        }

        public void setmDesc(String mDesc) {
            this.mDesc = mDesc;
        }

        public Integer getmImg() {
            return mImg;
        }

        public void setmImg(Integer mImg) {
            this.mImg = mImg;
        }
    }

}
