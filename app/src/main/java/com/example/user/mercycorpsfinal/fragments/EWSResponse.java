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
import com.example.user.mercycorpsfinal.activity.Sheet13;
import com.example.user.mercycorpsfinal.activity.Sheet14;
import com.example.user.mercycorpsfinal.activity.Sheet15;
import com.example.user.mercycorpsfinal.activity.Sheet16;
import com.example.user.mercycorpsfinal.activity.Sheet17;
import com.example.user.mercycorpsfinal.activity.Sheet18;
import com.example.user.mercycorpsfinal.activity.Sheet19;
import com.example.user.mercycorpsfinal.activity.Sheet20;
import com.example.user.mercycorpsfinal.activity.Sheet21;

/**
 * A simple {@link Fragment} subclass.
 */
public class EWSResponse extends Fragment {
    ListView lv;
    ArrayAdapter<String> adapter;
    View mView;
    String[] listItems={"जिल्ला विपद् प्रतिकार्य समिति ",
            "जिल्लास्थित :बकतभच त्चबष्लभच ९:त्० हरुको नाम, निकाय तथा सम्पर्क ",
    "पूर्व सूचना प्रणाली कार्यदल",
            "प्राथमिक उपचार कार्यदल",
            "खोज तथा उद्धार कार्यदल",
            "क्षेती तथा आबश्यक्ता लेखाजोखा कार्यदल",
            "प्राथमिक उपचार कार्यदल(नेपाल रेडक्रस सोसाइटी द्वारा गठित गा.वि.स. तथा नगरपालिका स्तरिय कार्यदलहरुको सम्पर्क विवरण)"
    ,"खोज तथा उद्धार कार्यदल( नेपाल रेडक्रस सोसाइटी द्वारा गठित गा.वि.स. तथा नगरपालिका स्तरिय कार्यदलहरुको सम्पर्क विवरण)"
            ,"पूर्व सूचना प्रणाली कार्यदल",
            "वाढी प्रभावित समुदायका ऋम्:ऋ  र  ध्म्:ऋ हरुको सम्पर्क बिवरण"
    ,"बर्षा मापन केन्द्र"};

    public EWSResponse() {
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
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_main_list_item, listItems);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){

                    case 0 :intent = new Intent(getActivity(), Sheet13.class);
                        startActivity(intent);
                        break;
                    case 1 :intent = new Intent(getActivity(), Sheet14.class);
                        startActivity(intent);
                        break;
                    case 2 :intent = new Intent(getActivity(), Sheet15.class);
                        startActivity(intent);
                        break;
                    case 3 :intent = new Intent(getActivity(), Sheet16.class);
                        startActivity(intent);
                        break;
                    case 4 :intent = new Intent(getActivity(), Sheet17.class);
                        startActivity(intent);
                        break;
                    case 5 :intent = new Intent(getActivity(), Sheet18.class);
                        startActivity(intent);
                        break;
                    case 6 :intent = new Intent(getActivity(), Sheet19.class);
                        startActivity(intent);
                        break;
                    case 7 :intent = new Intent(getActivity(), Sheet20.class);
                        startActivity(intent);
                        break;
                    case 8 :intent = new Intent(getActivity(), Sheet21.class);
                        startActivity(intent);
                        break;






                }

            }

        });
    }


}
