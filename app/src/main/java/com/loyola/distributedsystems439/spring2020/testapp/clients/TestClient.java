package com.loyola.distributedsystems439.spring2020.testapp.clients;

import com.loyola.distributedsystems439.spring2020.testapp.models.Question;
import com.loyola.distributedsystems439.spring2020.testapp.models.Questions;
import com.loyola.distributedsystems439.spring2020.testapp.models.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TestClient {

    @GET("activateQuestion")
    Call<Question> fetchActiveQuestion();

    /*
     TODO: This endpoint does not exist in the server API yet. As od 2/9,
     we can only retrieve the current `activeQuestion`
     */
    @GET("fetchAllQuestions")
    Call<Questions> fetchAllQuestions();

    @POST("recordResponse")
    Call<String> recordResponse(@Body Response answer);
}
