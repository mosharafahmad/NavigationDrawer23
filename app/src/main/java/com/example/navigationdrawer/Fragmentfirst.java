package com.example.navigationdrawer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

public class Fragmentfirst extends Fragment {

    public static String Web_url = "https://mosharaf-dental.netlify.app/";
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.fragment_fragmentfirst, container, false);

        WebView webView = myview.findViewById(R.id.webview);
        webView.loadUrl(Web_url);
        webView.getSettings().setJavaScriptEnabled(true);

        viewPager2 = myview.findViewById(R.id.viewPager2);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.tricount);
        images.add(R.drawable.ic_launcher_background);

        SliderAdapter adapter = new SliderAdapter(images);
        viewPager2.setAdapter(adapter);

        // Auto-slide setup
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // Slide every 3 seconds
            }
        });

        return myview;
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = viewPager2.getCurrentItem();
            int nextItem = (currentItem + 1) % 2; // Assuming 2 images as requested
            viewPager2.setCurrentItem(nextItem, true);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }
}