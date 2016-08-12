package com.example.rssdata.net;

import android.support.annotation.NonNull;

import com.example.rssdata.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 * Api Module class used to retrieve data from the cloud.
 */
public class ApiModule {

    @NonNull
    private final String baseUrl;
    @NonNull
    private final OkHttpClient.Builder httpClientBuilder;

    public ApiModule(@NonNull String baseUrl){
        this.baseUrl = baseUrl;

        httpClientBuilder = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        if(BuildConfig.DEBUG)
            httpClientBuilder.addInterceptor(logging);
    }

    /**
     * Provide {@link RssFeedAPI} with Retrofit client and xml converter factory
     * @return {@link RssFeedAPI}
     */
    @NonNull
    public RssFeedAPI provideApi(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClientBuilder.build())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RssFeedAPI.class);
    }
}
