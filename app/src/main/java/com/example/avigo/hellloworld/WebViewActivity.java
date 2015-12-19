package com.example.avigo.hellloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_layout);
        webView=(WebView) findViewById(R.id.wvGoogle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.google.com");

        webView.setWebChromeClient(new WebChromeClient());

        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}
