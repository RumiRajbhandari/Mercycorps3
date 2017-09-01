package com.example.user.mercycorpsfinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.user.mercycorpsfinal.R;
import com.example.user.mercycorpsfinal.VolleySingleton;
import com.example.user.mercycorpsfinal.adapter.CustomAdapterList;
import com.example.user.mercycorpsfinal.database.DatabaseHandler;
import com.example.user.mercycorpsfinal.model.ListItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KanchanpurList extends AppCompatActivity {
    CustomAdapterList adapter;
    private Toolbar toolbar;
    DatabaseHandler db;
    String url = "https://raw.githubusercontent.com/sushmagiri/MercyCorpsData/master/sheet1.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanchanpur_list);
        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db=new DatabaseHandler(this);
        LinearLayoutManager verticalLayoutmanager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
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
                                Intent i = new Intent(KanchanpurList.this, DetailActivity.class);
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
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);

    }




}