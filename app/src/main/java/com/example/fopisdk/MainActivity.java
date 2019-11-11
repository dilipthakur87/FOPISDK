package com.example.fopisdk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    LoadWebView loadWebView;
    Activity activity = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.load);

        loadWebView = new LoadWebView(getApplicationContext());
        loadWebView.loadFOPIAPP(webView, activity);


    }
}
