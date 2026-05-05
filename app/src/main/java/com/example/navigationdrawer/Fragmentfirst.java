package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class Fragmentfirst extends Fragment {



    public static String Web_url = "https://mosharaf-dental.netlify.app/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myview = inflater.inflate(R.layout.fragment_fragmentfirst, container, false);


        WebView webView = myview.findViewById(R.id.webview);
        webView.loadUrl(Web_url);
        webView.getSettings().setJavaScriptEnabled(true);





        return myview;
    }
}