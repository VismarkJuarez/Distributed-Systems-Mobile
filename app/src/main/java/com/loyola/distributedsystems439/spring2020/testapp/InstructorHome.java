package com.loyola.distributedsystems439.spring2020.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InstructorHome extends AppCompatActivity {
    private Button multiple_choice_btn;
    private Button fill_in_blank_btn;
    private Button true_false_btn;

    public void setup(){
        multiple_choice_btn = (Button)findViewById(R.id.MultipleChoicebtn);
        fill_in_blank_btn = (Button)findViewById(R.id.fill_in_blankbtn);
        true_false_btn = (Button)findViewById(R.id.true_falsebtn);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);
        setup();
        multiple_choice_btn.setOnClickListener(new chose_multiple_choice());
        fill_in_blank_btn.setOnClickListener(new chose_fill_in_blank());
        true_false_btn.setOnClickListener(new chose_true_false());

    }

    private class chose_multiple_choice implements View
            .OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),
                    "Selected Multiple Choice!",
                    Toast.LENGTH_LONG)
                    .show();
            startActivity(new Intent(InstructorHome.this, MCScreen.class));
        }

    }


    private class chose_fill_in_blank implements View
            .OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),
                    "Selected fill-in-the-blank!",
                    Toast.LENGTH_LONG)
                    .show();
            startActivity(new Intent(InstructorHome.this, fill_blank_screen.class));
        }
    }


        private class chose_true_false implements View
                .OnClickListener {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Selected true-or-false!",
                        Toast.LENGTH_LONG)
                        .show();
                startActivity(new Intent(InstructorHome.this, true_false_screen.class));
            }
    }
}

