package com.wixsite.joan.wixsite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private final static String sJSInterface = "com.wixsite.joan.wixsite.JS_INTERFACE_NAME";

    private WebView webWebView;

    private String[] saryWebsites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariablesAndUIObjects();
    }


    /**
     * Simple method where I declare,
     * initialize and use Class Variables,
     * and UI Objects.
     *
     * Called in this.onCreate();
     */
    private void initializeVariablesAndUIObjects() {

        saryWebsites = this.getResources().getStringArray(R.array.saryWebsites);

        ArrayAdapter<String> adpWebsites = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, saryWebsites);

        Spinner spnWebsite = (Spinner) this.findViewById(R.id.spnSelectWebsite);
        spnWebsite.setAdapter(adpWebsites);
        spnWebsite.setOnItemSelectedListener(islSpnWebSite);

        webWebView = (WebView) this.findViewById(R.id.webWebView);
        webWebView.addJavascriptInterface(new WebViewJSInterface(this, this, webWebView), sJSInterface);
        webWebView.setWebViewClient(new WebViewClient());
        WebSettings wesWebSettings = webWebView.getSettings();
        wesWebSettings.setJavaScriptEnabled(true);
        wesWebSettings.setBuiltInZoomControls(true);
    }


    /**
     * OnItemClickListener Interface for our Spinner object.
     * It listens for and handles click events on the spinner items.
     *
     * implemented in this.initializeVariablesAndUIObjects();
     */
    private Spinner.OnItemSelectedListener islSpnWebSite = new Spinner.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {
                case 0: //  First Website.
                    webWebView.loadUrl(saryWebsites[0]);
                    break;

                case 1: //  Second Website.
                    webWebView.loadUrl(saryWebsites[1]);
                    break;

                default:    //  Other Site. Just show 1st Website
                    webWebView.loadUrl(saryWebsites[0]);
                    break;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
