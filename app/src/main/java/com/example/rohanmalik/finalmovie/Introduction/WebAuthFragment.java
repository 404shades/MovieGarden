package com.example.rohanmalik.finalmovie.Introduction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rohanmalik.finalmovie.R;

/**
 * Created by Rohan Malik on 13-08-2017.
 */

public class WebAuthFragment extends Fragment {
    String requestToken;
    public WebAuthFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.web_auth,container,false);
       requestToken =  getArguments().getString("RequestToken");
        WebView webView = (WebView)view.findViewById(R.id.web_View);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://www.themoviedb.org/authenticate/" + requestToken);
        return view;
    }
}
