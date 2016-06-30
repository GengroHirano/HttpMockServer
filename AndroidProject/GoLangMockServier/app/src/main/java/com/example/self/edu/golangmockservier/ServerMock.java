package com.example.self.edu.golangmockservier;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by ootaakihiro on 16/02/18.
 */
public class ServerMock {

  private static final String FORUM_SERVER_URL = "http://localhost:8080/";
  private RetrofitApi mApi;

  public ServerMock() {

    OkHttpClient okHttpClient = new OkHttpClient();
    Retrofit restAdapter = new Retrofit.Builder()
            .baseUrl(FORUM_SERVER_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    mApi = restAdapter.create(RetrofitApi.class);
  }

  public RetrofitApi getApi() {
    return mApi;
  }

}
