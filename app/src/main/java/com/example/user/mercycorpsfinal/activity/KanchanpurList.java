package com.example.user.mercycorpsfinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.user.mercycorpsfinal.R;
import com.example.user.mercycorpsfinal.adapter.CustomAdapterList;
import com.example.user.mercycorpsfinal.model.ListItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KanchanpurList extends AppCompatActivity {
    private List<ListItem> entityArrayList=new ArrayList<>();
    CustomAdapterList adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanchanpur_list);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adapter = new CustomAdapterList(entityArrayList, new CustomAdapterList.OnItemClickListener() {
            @Override
            public void onItemClick(ListItem item) {
                Intent i=new Intent(KanchanpurList.this,DetailActivity.class);
                i.putExtra("data",(Serializable)item);
                startActivity(i);
            }
        });
        LinearLayoutManager verticalLayoutmanager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(verticalLayoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        prepareData();

    }

    private void prepareData()
    {
        entityArrayList.add(new ListItem("जिल्ला दै.प्र.उ.समिति/जिल्ला प्रशासन  कार्यालय"," श्री मनोहर प्रसाद खनाल (प्र.जि.अ.) ","९८५८७३७७७७"," ०९९–५२११०९"));
        entityArrayList.add(new ListItem("जिल्ला दै.प्र.उ.समिति/जिल्ला प्रशासन  कार्यालय (सम्पर्क व्यक्ति Focal Person) ","खगेन्द्र प्रसाद भट्ट ","9849507891","099-521178"));
        entityArrayList.add(new ListItem("जिल्ला दै.प्र.उ.समिति/जिल्ला प्रशासन कार्यालय"," प्रेम सिंह कुवर ","  ९७४९००२१५९  ","०९९–५२१११७८"));
        entityArrayList.add(new ListItem("जिल्ला विकास समितिको कार्यालय","मोहन पौडेल   (स्था. वि. अ.) ","9858750016","099-523778"));
        entityArrayList.add(new ListItem("जिल्ला विकास समितिको कार्यालय (सम्पर्क व्यक्ति Focal Person)    ","शिद्धराज पन्त ","9848731714","099-521327"));
        entityArrayList.add(new ListItem("जिल्ला प्राविधिक कार्यालय ","कमल कुमार अधिकारी","9858750930","099-524278"));
        entityArrayList.add(new ListItem("अंचल प्रहरी ईकाई कार्यालय ","राम प्रसाद श्रेष्ठ","9848794444","099-521156"));
        entityArrayList.add(new ListItem("जिल्ला प्रहरी कार्यालय "," तुलसी प्रसाद अधिकारी  ((प्र.उ)","9858735555","099-521200"));
        entityArrayList.add(new ListItem("सु.प. दंगा प्रहरी नियन्त्रण गण (प्र.उ)","  चिरञ्जीवि देबकोटा ","9858735555","099-521200"));
        entityArrayList.add(new ListItem("राष्ट्रि्य अनुसन्धान, जिल्ला कार्यालय"," भीम बहादुर बुढाथोकी","9847897922","099-521342"));
        entityArrayList.add(new ListItem("श्री २५ नं. बाहिनी अड्डा भगतपुर"," पदम कुमार आङ्बो","9851019815","099-525444"));
        entityArrayList.add(new ListItem("भवानी बक्स गण मझगाउ"," प्र.सेनानी श्री उत्तम थापा","९८५७०३६३४४","०९९४१४१५०"));
        entityArrayList.add(new ListItem("श्री सिंह शार्दुल गुल्म भगतपुर","सेनानी श्री सुजन शाक्य","९८५२६७१३३८","०९९५२१६४०"));
        entityArrayList.add(new ListItem("सशस्त्र प्रहरी बल सिमा सुरक्षा कार्यालय","श्री  तारादत्त पन्त   स.प्र.उ.","९८५१२७२१२०","०९९५२११०१"));
        entityArrayList.add(new ListItem("शैलेश्वरी सशस्त्र प्रहरी गण, झलारी"," रविन्द्र मल्ल स.प्र.उ.","९८५१०१०३६५","०९९५४०१३३"));
        entityArrayList.add(new ListItem("जिल्ला आपतकालीन कार्यसंचालन केन्द्र"," जनक पन्त","९८५८७९००८४","०९९५२५२४५"));
        entityArrayList.add(new ListItem("जल तथा मौसम विज्ञान विभाग फिल्ड कार्यालय अत्तरिया कैलाली","राममणी मिश्र","",""));
        entityArrayList.add(new ListItem("जिल्ला जन स्वास्थ्य कार्यालय"," शिव दत्त भटृ","9848318777","091-550622"));
        entityArrayList.add(new ListItem("जिल्ला जन स्वास्थ्य कार्यालय\n" +
                "(सम्पर्क व्यक्ति ायअब िएभचकयल)"," हेम राज जोशी","९८४८७२२३६१","०९९–५२१२९०"));
        entityArrayList.add(new ListItem("महाकाली अञ्चल अस्पताल","डा. श्रीराम तिवारी","९८४८७२०९९८","०९९५२१२६७"));
        entityArrayList.add(new ListItem("महाकाली अञ्चल आयूर्वेद अस्पताल"," अर्जुन प्र.उपाध्याय ","9851165087","099-521393"));
        entityArrayList.add(new ListItem("एभरेष्ट पोलीक्लिनिक झलारी","नविन जोशी","9759000511","099-521316"));
        entityArrayList.add(new ListItem("महिला विकास कार्यालय ","नविन जोशी","9848754699","099-540202"));
        entityArrayList.add(new ListItem("महिला विकास कार्यालय","जयन्ती गीरी","9858751866","099-523843"));
        entityArrayList.add(new ListItem("महिला विकास कार्यालय \n" +
                "(सम्पर्क व्यक्ति ायअब िएभचकयल)","  माला गौतम जोशी ","9848878140","099-523843"));
        entityArrayList.add(new ListItem("जिल्ला कृषि विकास कार्यालय","टिकाराम थापा","9858750052","099-521252"));
        entityArrayList.add(new ListItem("जिल्ला कृषि विकास कार्यालय \n" +
                "(सम्पर्क व्यक्ति ायअब िएभचकयल)","गोकुल प्रसाद बोहरा","",""));
        entityArrayList.add(new ListItem("जिल्ला पशु सेवा कार्यालय ","   डा. मदन सिंह धामी","",""));
        entityArrayList.add(new ListItem("खानेपानी तथा सरसफाइ डिभिजन कार्यालय","पूर्ण व. ज्वारचन ","",""));
        entityArrayList.add(new ListItem("खानेपानी तथा सरसफाइ डिभिजन कार्यालय\n" +
                "(सम्पर्क व्यक्ति ायअब िएभचकयल) ","गौराज लिम्वु","9858750665","099-521252"));
        entityArrayList.add(new ListItem("खानेपानी संस्थान","हरि कुमार श्रेष्ठ\tढडद्धठण्द्दठण्ण्द्द","9858050451","099-525657"));
        entityArrayList.add(new ListItem("अञ्चल यातायात कार्यालय\t","खेम प्रसाद चौधरी","9841294758","099-521134"));
        entityArrayList.add(new ListItem("जिल्ला शिक्षा कार्यालय","श्याम सिंह धामी ","9858750811","099-521134"));
        entityArrayList.add(new ListItem("जिल्ला शिक्षा कार्यालय\n" +
                "(सम्पर्क व्यक्ति ायअब िएभचकयल)","दिपक राज कलौनी ","",""));
        entityArrayList.add(new ListItem("महाकाली सिंचाइ व्यबस्थापन डिभिजन नं. ८ कार्यालय","अजय अधिकारी","",""));
        entityArrayList.add(new ListItem("महाकाली सिंचाई आयोजना कार्यालय","ईन्द्र देब भटृ\t","",""));
        entityArrayList.add(new ListItem("जनताको तटबन्ध फिल्ड नं. ७","भीलानन्द यादब","",""));
        entityArrayList.add(new ListItem("जनताको तटबन्ध फिल्ड नं. ७\n" +
                "(सम्पर्क व्यक्ति ायअब िएभचकयल)","मंगल बहादुर सिंह","",""));
        entityArrayList.add(new ListItem("जल उत्पन्न प्रकोप नियन्त्रण कार्यालय","रण ब.बम","",""));
        entityArrayList.add(new ListItem("जिल्ला भूसंरक्षण कार्यालय","गंगा दत्त जोशी","",""));
        entityArrayList.add(new ListItem("शुक्लाफााटा बन्यजन्तु आरक्ष","बेद कुमार ढकाल","",""));
        entityArrayList.add(new ListItem("डिभिजन सडक कार्यालय","विनोद कुमार मौवार","",""));
        entityArrayList.add(new ListItem("नेपाल खाद्य संस्थान","केशवदत्त कलौनी ","",""));
        entityArrayList.add(new ListItem("कृषि सामाग्री कम्पनि","विसन चन्द","",""));
        entityArrayList.add(new ListItem("जिल्ला खेलकुद विकास समिति","गोपालदत्त भटृ","९८४८७२००२७","०९९(५२२२१७"));
        entityArrayList.add(new ListItem("नेपाल टेलीकम","रुप बहादुर रावल","",""));
        entityArrayList.add(new ListItem("नेपाल विद्युत प्राधीकरण कार्यालय","गणेश प्र. पाण्डेय","",""));
        entityArrayList.add(new ListItem("महाकाली सेती बस व्यवसायी समिति ","नविन भट्ट","",""));
        entityArrayList.add(new ListItem("डिभिजन सहकारी कार्यालय","राम बहादुर खाती","",""));
        entityArrayList.add(new ListItem("क्षेत्रीय वाली संरक्षण प्रयोगशाला सुन्दरपुर","राजेन्द्र यादव","",""));
        entityArrayList.add(new ListItem("क्षेत्रीय कृषि तालिम केन्द्र सुन्दरपुर","दिव्य देभ भट्ट","",""));
        entityArrayList.add(new ListItem("क्षेत्रीय वीउा विजन प्रयोगशाला सुन्दरपुर","विमल थापा क्षेत्री","",""));
        entityArrayList.add(new ListItem("क्षेत्रीय बाली संरक्षण प्रयोगशाला सुन्दरपुर","गणेश यादव","",""));
        entityArrayList.add(new ListItem("क्षेत्रीय माटो परिक्षण प्रयोगशाला सुन्दरपु","नुनु लाल. उराउ","",""));
        entityArrayList.add(new ListItem("नगर विकास समिति ","ई.मोहनदेव भट्ट  ","",""));
        entityArrayList.add(new ListItem("मालपोत कार्यालय","कृष्ण कु. निरौला ","",""));
        entityArrayList.add(new ListItem("नापी कार्यालय","केशव राज लेखक ","",""));
        entityArrayList.add(new ListItem("भूमीसुधार कार्यालय","जानकी कार्की","",""));
        entityArrayList.add(new ListItem("व्यवसायी तथा सीप विकास तालिम केन्द्र","तर्कराज विष्ट","",""));
        entityArrayList.add(new ListItem("ग्रमीण आवास कम्पनी पुर्नवास","कर्मजित राई ","","०९९५६०१०३"));
        entityArrayList.add(new ListItem("राष्ट्रिय बाणिज्य बैंक ","हरिष चन्द्र भटृ","",""));
        entityArrayList.add(new ListItem("नेपाल बैंक लिमिटेड","कमल बहादुर चन्द","",""));
        entityArrayList.add(new ListItem("कृषि विकास बैंक","लिलाधर भटृ","",""));








    }

}
