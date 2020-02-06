package com.loyola.distributedsystems439.spring2020.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class UserInstructorSelection extends AppCompatActivity {

    //Storing references to the instructor and student buttons
    private Button studentButton = (Button)findViewById(R.id.studentButton);
    private Button instructorButton = (Button)findViewById(R.id.instructorButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_instructor_selection);




    }
}
