package com.example.shubhra.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {


    final EditText Name = (EditText) findViewById(R.id.editName);
    final EditText Email = (EditText) findViewById(R.id.editEmail);
    final Button save = (Button) findViewById(R.id.savebutton);
    int code=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        if(getIntent() != null && getIntent().getExtras() != null ){
            code = getIntent().getExtras().getInt("code");

            if (   code==DisplayActivity.NAME_KEY){
                Name.setVisibility(TextView.VISIBLE);
            }
            if (   code==DisplayActivity.EMAIL_KEY){
                Email.setVisibility(TextView.VISIBLE);
            }

        }
        findViewById(R.id.savebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent in = new Intent();
                // get the text from the EditText
                if (code == DisplayActivity.NAME_KEY) {
                    in.putExtra("result", Name.getText().toString());
                }
                if (code == DisplayActivity.EMAIL_KEY) {
                    in.putExtra("result", Email.getText().toString());
                }
                setResult(RESULT_OK, in);

                finish();
            }
        });


    }
    public void onButtonClick(View view) {

    }
}