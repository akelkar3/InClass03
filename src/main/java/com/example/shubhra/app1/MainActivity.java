package com.example.shubhra.app1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    public static String department;
    public static int mood;
    static String STUDENT_KEY = "Student";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nametext = findViewById(R.id.labelName);
        final EditText emailtext = findViewById(R.id.labelEmail);
        final RadioGroup radiogrouptext = findViewById(R.id.radioGroup);
        final SeekBar seekbartext = findViewById(R.id.seekBarMood);

        setTitle("Main Activity");
        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String name = nametext.getText().toString();
                String email = emailtext.getText().toString();
                int selectedId = radiogrouptext.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) findViewById(selectedId);

                department = (String) radioButton.getText();
                Log.d("demo", "department" + department);
                mood = seekbartext.getProgress();


                Log.d("demo", "name" + name);
                Log.d("demo", "email" + email);
                Log.d("demo", "mood" + mood);


                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

                Student student = new Student(name, email, department, mood);

                intent.putExtra("STUDENT_KEY", student);

                startActivity(intent);


            }});


    }
}
