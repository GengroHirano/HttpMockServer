package com.example.self.edu.golangmockservier;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by ootaakihiro on 16/02/18.
 */
public interface RetrofitApi {

  @GET("hello")
  Observable<String> getHello();

}
