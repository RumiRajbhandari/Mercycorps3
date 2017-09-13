package com.example.user.mercycorpsfinal.Api;

import android.content.Context;

import com.example.user.mercycorpsfinal.helper.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 9/3/2017.
 */

public class ApiHelper {
    public static final String BASE_URL = "https://raw.githubusercontent.com/sushmagiri/MercyCorpFinalData/master/";



    public MercyCorpInterface getApiInterface() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient = addLogging(httpClient);
        httpClient.connectTimeout(10, TimeUnit.MINUTES);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiHelper.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        MercyCorpInterface api = retrofit.create(MercyCorpInterface.class);

        return api;
    }

    public MercyCorpInterface getApiWithCaching(final Context context) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient = addLogging(httpClient);

        httpClient.cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024));

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (Utils.networkIsAvailable(context)) {
                    request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                } else {
                    request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 28*12).build();
                }
                return chain.proceed(request);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiHelper.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        MercyCorpInterface api = retrofit.create(MercyCorpInterface.class);

        return api;
    }

    public OkHttpClient.Builder addLogging(OkHttpClient.Builder builder){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(logging);

        return builder;
    }

}

