package com.example.shubhra.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    static  int NAME_KEY = 2;
    static  int EMAIL_KEY = 3;
    static  int DEPART_KEY = 4;
    static int MOOD_KEY= 5;
    static int RESULT_OK =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        final TextView Name = (TextView) findViewById(R.id.name);
        final TextView Email = (TextView) findViewById(R.id.email);
        final TextView Department = (TextView) findViewById(R.id.department);
        final TextView Mood = (TextView) findViewById(R.id.mood);
        //  Student std = new Student("a","b","c", 70);
        if(getIntent() != null && getIntent().getExtras() != null ){


            Student std = (Student)getIntent().getExtras().getSerializable("STUDENT_KEY");

            Name.setText(std.name);
            Email.setText(std.email);
            Department.setText(std.department);
            Mood.setText( Integer.toString(std.mood) );
        }

        final Intent i = new Intent("com.example.aliandro.inclass3.intent.action.Edit");
        final ImageButton editName = (ImageButton) findViewById(R.id.imageButtonName);
        editName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                i.putExtra("nameKey",Name.getText());
                i.putExtra("code",NAME_KEY);

                startActivityForResult(i, NAME_KEY);

            }
        });
        final ImageButton editEmail = (ImageButton) findViewById(R.id.imageButtonEmail);
        editEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                i.putExtra("nameKey",Email.getText());
                i.putExtra("code",EMAIL_KEY);
                startActivityForResult(i, EMAIL_KEY);

            }
        });
        final ImageButton editDep = (ImageButton) findViewById(R.id.imageButtonDep);
        editDep.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                i.putExtra("nameKey", Department.getText());
                i.putExtra("code",DEPART_KEY);
                startActivityForResult(i, DEPART_KEY);

            }
        });
        final ImageButton editMood = (ImageButton) findViewById(R.id.imageButtonMood);
        editDep.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                i.putExtra("nameKey", Mood.getText());
                i.putExtra("code",MOOD_KEY);
                startActivityForResult(i, MOOD_KEY);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                String returnString = data.getStringExtra("result");

                // set text view with string
                TextView textView = (TextView) findViewById(R.id.name);
                textView.setText(returnString);
            }
        }
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                String returnString = data.getStringExtra("result");

                // set text view with string
                TextView textView = (TextView) findViewById(R.id.email);
                textView.setText(returnString);
            }
        }
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                String returnString = data.getStringExtra("result");

                // set text view with string
                TextView textView = (TextView) findViewById(R.id.department);
                textView.setText(returnString);
            }
        }
        if (requestCode == 4) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                String returnString = data.getStringExtra("result");

                // set text view with string
                TextView textView = (TextView) findViewById(R.id.mood);
                textView.setText(returnString);
            }
        }
    }
}
