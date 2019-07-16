package com.example.alc4phase1;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
//Import the WebView and WebViewClient classes//
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.webkit.WebSettings;


public class AboutALC extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        WebView htmlWebView = (WebView)findViewById(R.id.webview);
        htmlWebView.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = htmlWebView.getSettings();
        htmlWebView.getSettings().setJavaScriptEnabled(true);
        htmlWebView.getSettings().setLoadWithOverviewMode(true);
        htmlWebView.getSettings().setUseWideViewPort(true);
        htmlWebView.getSettings().setDomStorageEnabled(true);
        htmlWebView.setWebChromeClient(new WebChromeClient());
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);

        htmlWebView.loadUrl("https://andela.com/alc/");
    }

    private class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }
    }




    }



