package com.example.practical14_studentregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,rollNo;
    Spinner subjects;
    RadioGroup genders;
    CheckBox enroll_course;
    Button register;
    String subject,gender,choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        subjects.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subject=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Please select an item", Toast.LENGTH_SHORT).show();
            }
        });

        genders.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.male:
                        gender="Male";
                        break;
                    case R.id.female:
                        gender="Female";
                        break;
                }
            }
        });

        enroll_course.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    choice="Yes";
                }
                else{
                    choice="No";
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShowDetails.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("rollNo",rollNo.getText().toString());
                intent.putExtra("subject",subject);
                intent.putExtra("gender",gender);
                intent.putExtra("choice",choice);
                startActivity(intent);
            }
        });
    }
    public void init(){
        name=findViewById(R.id.name);
        rollNo=findViewById(R.id.roll_no);
        subjects=findViewById(R.id.spinner);
        genders=findViewById(R.id.radiogroup);
        enroll_course=findViewById(R.id.checkbox);
        register=findViewById(R.id.register);
    }
}