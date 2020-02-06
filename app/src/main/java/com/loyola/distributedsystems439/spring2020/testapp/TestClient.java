package com.loyola.distributedsystems439.spring2020.testapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TestClient {

    @GET("fetchAllQuestions")
    Call<Questions> fetchAllQuestions();

    @POST("submitAnswer")
    Call<String> submitAnswer(@Body Answer answer);
}
