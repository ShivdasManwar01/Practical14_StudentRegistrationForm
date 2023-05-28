package com.example.practical14_studentregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {
    TextView name,rollNO,subject,gender,choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        init();
        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        rollNO.setText(intent.getStringExtra("rollNo"));
        subject.setText(intent.getStringExtra("subject"));
        gender.setText(intent.getStringExtra("gender"));
        choice.setText(intent.getStringExtra("choice"));
    }

    public void init(){
        name=findViewById(R.id.name);
        rollNO=findViewById(R.id.roll_no);
        subject=findViewById(R.id.subject);
        gender=findViewById(R.id.gender);
        choice=findViewById(R.id.choice);
    }
}