package com.mercycorps.ews.Api;

import com.mercycorps.ews.model.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 9/3/2017.
 */

public interface MercyCorpInterface {
    @GET("ApatKalinAwastha.json")
    Call<List<ListItem>> getList1();
    @GET("ApatKalinAwastha.json")
    Call<List<ListItem>> getList2();

    @GET("AtyantaJarooriNumber.json")
    Call<List<ListItem>> getList3();

    @GET("GairSarkariSastha.json")
    Call<List<ListItem>> getList4();

    @GET("sheet5.json")
    Call<List<ListItem>> getList5();
    @GET("KadhyaKaryaSamuha.json")
    Call<List<ListItem>> getList6();
    @GET("AwasahTathaGairKadhyanna.json")
    Call<List<ListItem>> getList7();
    @GET("KhaneyPaniSipharisTathaSwasthya.json")
    Call<List<ListItem>> getList8();

    @GET("SwasthyaTathaPoshanKshetraContact.json")
    Call<List<ListItem>> getList9();

    @GET("SamrakchyanKshetraSamparkaByakti.json")
    Call<List<ListItem>> getList10();


    @GET("ShikshyaKshetraSamparkaByakti.json")
    Call<List<ListItem>> getList11();

    @GET("PurnaSthapanTathaPurnaNirmanKaralaya.json")
    Call<List<ListItem>> getList12();
    @GET("JillaBipatPrakriyaSamiti.json")
    Call<List<ListItem>> getList13();
    @GET("JIllaStithMasterTrainerDetail.json")
    Call<List<ListItem>> getList14();

    @GET("PurbaSuchanaPranaliKaryaDal.json")
    Call<List<ListItem>> getList15();
    @GET("PrathamikUpacharKaryaDal.json")
    Call<List<ListItem>> getList16();
    @GET("KhojTathaUddharKaryalaya.json")
    Call<List<ListItem>> getList17();
    @GET("ChyaatiTathaAwasektaKaryalaya.json")
    Call<List<ListItem>> getList18();
    @GET("PrathamikUpacharKaryaDal.json")
    Call<List<ListItem>> getList19();

    @GET("KhojTathaUdharKaryaDalRedCross.json")
    Call<List<ListItem>> getList20();
    @GET("PurbaSuchanaPranaliKaryaDalRedCross.json")
    Call<List<ListItem>> getList21();
    @GET("JalMapanKendra.json")
    Call<List<ListItem>> getList26();
    @GET("BarshaMapanKendra.json")
    Call<List<ListItem>> getList27();
    @GET("Unamed.json")
    Call<List<ListItem>> getList25();



}
