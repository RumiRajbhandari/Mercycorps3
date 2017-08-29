package com.example.user.mercycorpsfinal.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mercycorpsfinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmergencyNumbers extends Fragment {

    FragmentTabHost mTabHost;

    public EmergencyNumbers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank,container, false);

        mTabHost = (FragmentTabHost) v.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(),getChildFragmentManager(),R.id.tabcontent);
//        mTabHost.addTab(mTabHost.newTabSpec("Red Cross").setIndicator("Red Cross"),RedCrossFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("DDRT").setIndicator("DDRT"),DDRT.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("Security Forces").setIndicator("Security Forces"),SecurityForces.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("Fire Brigade").setIndicator("Fire Brigade"),FireBrigadeFragment.class,null);


        return v;
    }

}
