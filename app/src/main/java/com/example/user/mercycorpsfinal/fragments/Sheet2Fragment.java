package com.example.user.mercycorpsfinal.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class Sheet2Fragment extends Fragment {
    CustomAdapterList adapter;
//    private Toolbar toolbar;
    DatabaseHandler db;
    String url = "https://raw.githubusercontent.com/sushmagiri/MercyCorpsData/master/sheet2.json";
    View mView;
    public Sheet2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_sheet2, container, false);
        final RecyclerView rv = (RecyclerView) mView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        db=new DatabaseHandler(this);
//
        LinearLayoutManager verticalLayoutmanager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(verticalLayoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        Gson gson=new Gson();
                        List<ListItem> listItems;
                        listItems=gson.fromJson(response.toString(),new TypeToken<ArrayList<ListItem>>(){}.getType());

//                        db.addUser(listItems);
                        adapter = new CustomAdapterList(listItems, new CustomAdapterList.OnItemClickListener() {
                            @Override
                            public void onItemClick(ListItem item) {
                                Intent i = new Intent(getActivity(), DetailActivity.class);
                                i.putExtra("data", (Serializable) item);
                                startActivity(i);
                            }
                        });
                        rv.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Adding request to request queue
        VolleySingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonArrayRequest);

        return mView;

    }


}
