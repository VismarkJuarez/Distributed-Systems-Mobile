package com.vismark.distributedsystems.loyola.testapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface TestClient {

    @GET("fetchAllQuestions")
    Call<Questions> fetchAllQuestions();

    @POST("submitAnswer")
    Call<String> submitAnswer(@Body Answer answer);
}
