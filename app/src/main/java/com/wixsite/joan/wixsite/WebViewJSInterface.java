package com.wixsite.joan.wixsite;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * This is a JavaScript Interface for the WebView on our Main Activity.
 * It handles JavaScript operations.
 * Key operation is maintaining security by making sure the WebView in our Application,
 * doesn't access another site outside the wixsite.com domain!
 *
 * We then reference this class in out MainActivity.java
 */
public class WebViewJSInterface {

    private Context coxContext;
    private Activity actActivity;

    private WebView webWebView;

    public WebViewJSInterface(Context context, Activity activity, WebView webView) {
        this.coxContext = context;
        this.actActivity = activity;

        this.webWebView = webView;
    }

    @JavascriptInterface
    public void showToast(String message) {

        this.actActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                if (!webWebView.getUrl().contains("http://www.wixsite.com")) {
                    //  If Site doesn't belong to Google, return without doing anything else.
                    //  This improves Security since JS can mess up with your Android Code.
                    return;
                }
            }
        });

        message = "This is a JavaScript Interface helps maintain security. Keep to your grounds!";
        Toast.makeText(coxContext, message, Toast.LENGTH_SHORT).show();

    }
}
