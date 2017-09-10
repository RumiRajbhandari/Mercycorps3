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

import com.example.user.mercycorpsfinal.Api.ApiHelper;
import com.example.user.mercycorpsfinal.Api.MercyCorpInterface;
import com.example.user.mercycorpsfinal.R;
import com.example.user.mercycorpsfinal.activity.DetailActivity;
import com.example.user.mercycorpsfinal.adapter.CustomAdapterList;
import com.example.user.mercycorpsfinal.database.DatabaseHandler;
import com.example.user.mercycorpsfinal.model.ListItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sheet26Fragment extends Fragment {
    CustomAdapterList adapter;
    DatabaseHandler db;
    View mView;
    RecyclerView rv;
    List<ListItem> userList;

    public Sheet26Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_sheet2, container, false);
        rv = (RecyclerView) mView.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);

//        db=new DatabaseHandler(this);
//
        LinearLayoutManager verticalLayoutmanager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(verticalLayoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());
        userList=new ArrayList<>();
        fetchDetails();
        return mView;


    }
    private void fetchDetails() {
        final MercyCorpInterface apiService = new ApiHelper().getApiWithCaching(getContext());
//        MercyCorpInterface apiService = ApiHelper.getClient().create(MercyCorpInterface.class);
        Call<List<ListItem>> call = apiService.getList26();
        call.enqueue(new Callback<List<ListItem>>() {
            @Override
            public void onResponse(Call<List<ListItem>> call, retrofit2.Response<List<ListItem>> response) {


                userList.addAll(response.body());
                adapter = new CustomAdapterList(userList, new CustomAdapterList.OnItemClickListener() {
                    @Override
                    public void onItemClick(ListItem item) {
                        Intent i = new Intent(getActivity(), DetailActivity.class);
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
