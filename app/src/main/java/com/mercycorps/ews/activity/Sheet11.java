package com.mercycorps.ews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mercycorps.ews.Api.ApiHelper;
import com.mercycorps.ews.Api.MercyCorpInterface;
import com.mercycorps.ews.R;
import com.mercycorps.ews.adapter.CustomAdapterList;
import com.mercycorps.ews.model.ListItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;

public class Sheet11 extends AppCompatActivity {
    CustomAdapterList adapter;
    private Toolbar toolbar;
    List<ListItem> userList;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanchanpur_list);
        rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//        api = new ApiHelper().getApiWithCaching(getApplicationContext());
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        userList=new ArrayList<>();
        LinearLayoutManager verticalLayoutmanager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(verticalLayoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());
        fetchDetails();
    }
    private  void  fetchDetails() {
        final MercyCorpInterface apiService = new ApiHelper().getApiWithCaching(getApplicationContext());
        Call<List<ListItem>> call = apiService.getList11();
        call.enqueue(new Callback<List<ListItem>>() {
            @Override
            public void onResponse(Call<List<ListItem>> call, retrofit2.Response<List<ListItem>> response) {
                try{
                    userList.addAll(response.body());
                }catch (Exception e){
                    Toast.makeText(Sheet11.this, "Please Connect to Internet", Toast.LENGTH_SHORT).show();
                }
                adapter = new CustomAdapterList(userList, new CustomAdapterList.OnItemClickListener() {
                    @Override
                    public void onItemClick(ListItem item) {
                        Intent i = new Intent(Sheet11.this, DetailActivity.class);
                        i.putExtra("data", (Serializable) item);
                        startActivity(i);
                    }
                });
                rv.setAdapter(adapter);

            }


            @Override
            public void onFailure(Call<List<ListItem>> call, Throwable t) {

            }
        });
    }
}
