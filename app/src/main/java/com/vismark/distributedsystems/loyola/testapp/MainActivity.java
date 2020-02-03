package com.vismark.distributedsystems.loyola.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loadQuestionsButton = (Button)findViewById(R.id.loadQuestionsButton);
        loadQuestionsButton.setOnClickListener(new loadQuestionsButtonClicked());

        Button firstButton = (Button)findViewById(R.id.submitButton);


        //Setting onClick behaviour
        firstButton.setOnClickListener(new buttonOneClicked());
    }

    //OnClick button handler classes
    private class buttonOneClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            submitAnswer();
        }
    }

    private class loadQuestionsButtonClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            fetchAllQuestions();
        }
    }

    private void renderAllQuestions(String allQuestions) {
        Log.i("INFO", "Trying to set text");
        //TODO references to TextView and setting movement method should be global -- or at least
        //contained within a startup method.
        TextView questionTextView = (TextView)findViewById(R.id.questionLabel);
        questionTextView.setMovementMethod(new ScrollingMovementMethod());

        Log.i("INFO", "Trying to set to: " + allQuestions);
        questionTextView.setText(allQuestions);
    }

    private String fetchAllQuestions() {
        Log.i("INFO","Attempting to fetch all Questions from the instructor server!");

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5001/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        TestClient client = retrofit.create(TestClient.class);
        Call<Questions> call = client.fetchAllQuestions();

        call.enqueue(new Callback<Questions>() {

            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Toast.makeText(getApplicationContext(),
                        "Call made successfully!",
                        Toast.LENGTH_LONG)
                        .show();
                Log.i("INFO","Call was made successfully!");

                Log.i("INFO", response.body().toString());
                renderAllQuestions(response.body().toString());
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {
                Log.i("ERROR","Something blew up!");
                t.printStackTrace();
                Log.i("INFO", call.request().toString());
            }
        });

        return "All good"; //TODO refactor this out

    }




    //Ancillary methods
    private void submitAnswer() {
        Toast.makeText(getApplicationContext(),
                "Answer has been submitted.",
                Toast.LENGTH_LONG)
                .show();

        sendNetworkRequest("This is an example payload");
    }

    private void sendNetworkRequest(String data) {

        Log.i("INFO","Attempting to make REST call now!");

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        TestClient client = retrofit.create(TestClient.class);
        Call<String> call = client.updateAnswer1Count(data);

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(),
                        "Call made successfully!",
                        Toast.LENGTH_LONG)
                        .show();
                Log.i("INFO","Call waas made successfully!");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("ERROR","Something blew up!");
                t.printStackTrace();
                Log.i("INFO", call.request().toString());
            }
        });
    }

}
