package com.bitm.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText firstnameEt, lastnameET, emailET, passwordET;
    private AutoCompleteTextView bloodgroupACTV;
    private CheckBox conditionCB;
    private Button signupBtn;
    private String[] bloodgroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, bloodgroup);
        bloodgroupACTV.setAdapter(adapter);
        bloodgroupACTV.setThreshold(1);


        conditionCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {

                if (check == true) {

                    signupBtn.setVisibility(View.VISIBLE);


                } else {

                    signupBtn.setVisibility(View.GONE);
                }
            }
        });




    }


    private void init() {

        firstnameEt = findViewById(R.id.firstnameET);
        lastnameET = findViewById(R.id.lastnameET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        bloodgroupACTV = findViewById(R.id.bloodgroupACTV);
        conditionCB = findViewById(R.id.conditionCB);
        signupBtn = findViewById(R.id.signupBtn);


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (firstnameEt.length() == 0)
                {
                    firstnameEt.setError("Enter First Name");
                }
                else if (lastnameET.length() == 0)
                {
                    lastnameET.setError("Enter Last Name");
                }
                else if (emailET.length() == 0)
                {
                    emailET.setError("Enter Email");
                }
                else if (passwordET.length() == 0)
                {
                    passwordET.setError("Enter Password");
                }
                else if (bloodgroupACTV.length() == 0)
                {
                    bloodgroupACTV.setError("Enter Blood Group");
                }
                else
                {

                    Toast.makeText(MainActivity.this, "Successfully Signup", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
