package com.br.otavianosilverio.termodeuso3d2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PoliticaPrivacidade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politica_privacidade);

        WebView webView = (WebView) findViewById(R.id.wv_content);
        webView.loadUrl("http://otavianosilverio.com.br/politica-de-privacidade/");
    }
}
