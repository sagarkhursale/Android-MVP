package com.sagar.androidmvp.http;

import android.support.annotation.NonNull;
import java.io.IOException;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



@Module
public class ApiModuleForInfo {
    private final String BASE_URL = "http://www.omdbapi.com";
    private final String API_KEY="56e9a443";


    @Provides
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter("apikey", API_KEY).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        }).build();
    }


    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Provides
    public MoreInfoApiService provideApiService() {
        return provideRetrofit(BASE_URL, provideClient()).create(MoreInfoApiService.class);
    }


    // END
}

