package com.aplihs.whatsweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://web.whatsapp.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        String newUA3 = "Mozilla/5.0 (X11; Linux i686; rv:90.0) Gecko/20100101 Firefox/90.0.";
        webView.getSettings().setUserAgentString(newUA3);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onPermissionRequest(PermissionRequest request) {
                request.grant(request.getResources());
            }
        });
        webView.loadUrl(url);
    }
}