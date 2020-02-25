package com.loyola.distributedsystems439.spring2020.testapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserInstructorSelection extends AppCompatActivity {

    //Creating references to the instructor and student buttons
    private Button STUDENT_BUTTON;
    private Button INSTRUCTOR_BUTTON;
    private Button QR_BUTTON;

    private void setup() {
        //Initializing button references
        STUDENT_BUTTON = (Button)findViewById(R.id.studentButton);
        INSTRUCTOR_BUTTON = (Button)findViewById(R.id.instructorButton);
        QR_BUTTON = (Button)findViewById(R.id.QRButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_instructor_selection);

        setup();

        //setting onClick behaviour
        STUDENT_BUTTON.setOnClickListener(new studentButtonClicked());
        INSTRUCTOR_BUTTON.setOnClickListener(new instructorButtonClicked());
        QR_BUTTON.setOnClickListener(new instructorButtonClicked());
    }
    //OnClick button handler classes
    private class QRButtonClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),
                    "QRButton clicked!",
                    Toast.LENGTH_LONG)
                    .show();
            startActivity(new Intent(UserInstructorSelection.this, QRcode.class));
        }
    }

    //OnClick button handler classes
    private class studentButtonClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),
                    "StudentButton clicked!",
                    Toast.LENGTH_LONG)
                    .show();
            startActivity(new Intent(UserInstructorSelection.this, StudentHome.class));
        }
    }

    private class instructorButtonClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),
                    "InstructorButton clicked!",
                    Toast.LENGTH_LONG)
                    .show();
            startActivity(new Intent(UserInstructorSelection.this, InstructorHome.class));
        }
    }

}
