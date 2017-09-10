package com.example.user.mercycorpsfinal.fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.user.mercycorpsfinal.R;
import com.example.user.mercycorpsfinal.VolleySingleton;
import com.example.user.mercycorpsfinal.activity.DetailActivity;
import com.example.user.mercycorpsfinal.adapter.CustomAdapterList;
import com.example.user.mercycorpsfinal.database.DatabaseHandler;
import com.example.user.mercycorpsfinal.model.ListItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebRiver extends Fragment {
    View mView;
    FragmentTabHost mTabHost;
    String url="http://hydrology.gov.np/new/bull3/index.php/hydrology/screen_display";

    public  WebRiver(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_dhm, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final WebView myWebView = (WebView) view.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(true);



        myWebView.loadUrl(url);
        myWebView.postDelayed(new Runnable() {

            @Override
            public void run() {
                myWebView.loadUrl(url);
            }
        }, 500);

        /*Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse(url));
        startActivity(viewIntent);*/

    }

}
