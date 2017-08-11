package com.example.user.mercycorpsfinal.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.mercycorpsfinal.R;
import com.example.user.mercycorpsfinal.activity.KanchanpurList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImportantContactsFragment extends Fragment {
    ListView lv;
    ArrayAdapter<String> adapter;
    View mView;
    String[] listItems={"कञ्चनपुर जिल्लाका विपद्संग सम्बन्धित सरोकारवालाहरु  सरकारी कार्यालय",
            "जिल्ला स्तिथ राजनैतिक दलहरु",
            "अन्तराष्ट्रिय गैर सरकारी संस्था",
            "गैर सरकारी संस्था ",
            "सुअर्क्श्य निकाय ",
            "टेलिभिजन/पत्रपत्रिका/एफ. एम. ",
            "आकस्मिक सेवा १२ कञ्चनपुर जिल्लाका गाविसहरु ",
            "वर्षा मापन केन्द्रहरु १६ जल मापन केन्द्रहरु ",
            " वाढी प्रभावित समुदाय ",
              " वाढी प्रभावित समुदाय र सामुदायिक विपद् व्यवस्थापन समिति ",
             "नेपाल रेडक्रस सोसाईटी उपशाखाहरु"};

    public ImportantContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_important_contacts, container, false);
       return mView;



    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ListView) mView.findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.activity_main_list_item, listItems);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){

                    case 0 :intent = new Intent(getActivity(), KanchanpurList.class);
                        startActivity(intent);
                        break;


                }

            }

        });
    }


}
