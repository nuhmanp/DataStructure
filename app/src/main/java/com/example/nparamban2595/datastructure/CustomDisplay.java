package com.example.nparamban2595.datastructure;
/**
 * Custom Display activity for adding web view
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class CustomDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_display);
        //Video html element to embedd
        String frameVideo = "<html><body>BBC Sports" +
                " <br> <iframe width='320' height='315' src='https://www.youtube.com/embed/cwL9oQEW4rg' frameborder='0' allowfullscreen></iframe></body></html>";

        //find webView element from XML
        WebView displayVideo = (WebView)findViewById(R.id.webView);
        //set webview client
        displayVideo.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        //getting webview setting
        WebSettings webSettings = displayVideo.getSettings();
        //setting javascript enabled
        webSettings.setJavaScriptEnabled(true);
        //load video
        displayVideo.loadData(frameVideo, "text/html", "utf-8");
    }
}
