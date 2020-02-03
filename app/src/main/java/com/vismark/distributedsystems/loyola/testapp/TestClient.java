package com.vismark.distributedsystems.loyola.testapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface TestClient {
    @PUT("question1")
    Call<String> updateAnswer1Count(@Body String data);

    @GET("submitAnswer")
    Call<String> submitAnswer(@Body Answer answer);
}
