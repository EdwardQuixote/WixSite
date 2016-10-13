package com.wixsite.joan.wixsite;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

/**
 * This is a Client class for our WebView on the main Activity.
 * It acts as the Handler class for our WebView and that's why
 * it extends the Subclass: android.webkit.WebViewClient.
 * It handles operations/events performed on our webview.
 * It handles what our webview is doing e.g. Command which sites to be loaded.
 *
 * Referenced from our MainActivity.java class.
 */
public class WebViewClient extends android.webkit.WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if (Uri.parse(url).getHost().equals("www.wixsite.com")) {
            //  This is the authorized Website, so no override. Let webview load Page.
            return false;
        }

        //  This link is not of the authorized website. so launch in another program.
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //  startActivity(intent);
        return true;
    }

}
