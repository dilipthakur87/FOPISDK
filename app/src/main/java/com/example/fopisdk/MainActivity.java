package com.example.fopisdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button loadFopi;
    WebView webView;
    LoadWebView loadWebView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.load);
//
        loadWebView = new LoadWebView(getApplicationContext());
        LoadWebView.loadFOPIAPP(webView);
//        webView.loadUrl("http://kandktechnepal.com/");



    }
}
