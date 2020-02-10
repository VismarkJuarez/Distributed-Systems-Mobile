package com.loyola.distributedsystems439.spring2020.testapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loyola.distributedsystems439.spring2020.testapp.R;
import com.loyola.distributedsystems439.spring2020.testapp.clients.TestClient;
import com.loyola.distributedsystems439.spring2020.testapp.models.Questions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        Button loadQuestionsButton = (Button)findViewById(R.id.loadQuestionsButton);
        loadQuestionsButton.setOnClickListener(new LoadQuestionsButtonClicked());

        Button submitButton = (Button)findViewById(R.id.submitButton);

        //Setting onClick behaviour
        submitButton.setOnClickListener(new SubmitButtonClicked());

    }

    //OnClick button handler classes
    private class SubmitButtonClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            submitAnswer();
        }
    }

    private class LoadQuestionsButtonClicked implements View.OnClickListener {
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
                .baseUrl("http://10.0.2.2:5000/")
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

        //extract the questionId, as specified by the student
        int questionId = Integer.parseInt(((EditText)findViewById(R.id.questionIdLabel)).getText().toString());
        //int questionIdAsInt = Integer.parseInt(questionIdAsString);

        //extract the answer, as specified by the student (TODO this is ugly -- cleanup required.
        String studentAnswer = ((EditText)findViewById(R.id.studentAnswerEditText)).getText().toString();

        Answer answerData = new Answer(questionId, studentAnswer);

        Toast.makeText(getApplicationContext(),
                "Answer has been submitted.",
                Toast.LENGTH_LONG)
                .show();

        Log.i("INFO", "SENDING THE FOLLOWING PAYLOAD: " + answerData.toString());

        sendAnswer(answerData);
    }

    private void sendAnswer(Answer answerData) {

        Log.i("INFO","Attempting to make REST call now!");

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        TestClient client = retrofit.create(TestClient.class);
        Call<String> call = client.submitAnswer(answerData);

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
