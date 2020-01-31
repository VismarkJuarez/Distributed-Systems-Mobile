package com.vismark.distributedsystems.loyola.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        //Creating references to each of the 4 buttons
        Button firstButton = (Button)findViewById(R.id.button1);
        Button secondButton = (Button)findViewById(R.id.button2);
        Button thirdButton = (Button)findViewById(R.id.button3);
        Button fourthButton = (Button)findViewById(R.id.button4);

        //Setting onClick behaviour
        firstButton.setOnClickListener(new buttonOneClicked());
        secondButton.setOnClickListener(new buttonTwoClicked());
        thirdButton.setOnClickListener(new buttonThreeClicked());
        fourthButton.setOnClickListener(new buttonFourClicked());
    }

    //OnClick button handler classes
    private class buttonOneClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            incrementAnswer1Count();
        }
    }

    private class buttonTwoClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            incrementAnswer2Count();
        }
    }
    private class buttonThreeClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            incrementAnswer3Count();
        }
    }
    private class buttonFourClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            incrementAnswer4Count();
        }
    }

    //Ancillary methods
    private void incrementAnswer1Count() {
        Toast.makeText(getApplicationContext(),
                "Button1 has been pressed.",
                Toast.LENGTH_LONG)
                .show();

        sendNetworkRequest("This is an example payload");
    }

    private void incrementAnswer2Count() {
        Toast.makeText(getApplicationContext(),
                "Button2 has been pressed.",
                Toast.LENGTH_LONG)
                .show();
    }

    private void incrementAnswer3Count() {
        Toast.makeText(getApplicationContext(),
                "Button3 has been pressed.",
                Toast.LENGTH_LONG)
                .show();
    }

    private void incrementAnswer4Count() {
        Toast.makeText(getApplicationContext(),
                "Button4 has been pressed.",
                Toast.LENGTH_LONG)
                .show();
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
