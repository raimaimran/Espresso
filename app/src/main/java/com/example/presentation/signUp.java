package com.example.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class signUp extends AppCompatActivity {

    TextView txt;
    Button btn;
    RadioGroup gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txt= (TextView) findViewById(R.id.redirectsignin);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn = (Button) findViewById(R.id.signupButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = findViewById(R.id.nameField);
                if (name.getText().toString().isEmpty()) {

                    TextView tv = findViewById(R.id.incorrectmail);
                    tv.setText("You must enter your name");
                    return;
                }
                EditText uname = findViewById(R.id.emailField);
                if (uname.getText().toString().isEmpty()) {

                    TextView tv = findViewById(R.id.incorrectmail);
                    tv.setText("You must enter your email");
                    return;
                } else if (uname.getText().toString().contains("@") != true) {
                    TextView tv = findViewById(R.id.incorrectmail);
                    tv.setText("You must enter a valid email.");
                    return;
                }
                EditText pass = findViewById(R.id.passwordField);
                if (pass.getText().toString().isEmpty()) {
                    TextView tv = findViewById(R.id.incorrectmail);
                    tv.setText("You must enter your password");
                    return;

                }
                else if (pass.getText().toString().length()< 8) {
                    TextView tv = findViewById(R.id.incorrectmail);
                    tv.setText("Password must have more than 8 characters");
                    return;
                }
                EditText confirmPass = findViewById(R.id.confirmPasswordField);
                if (confirmPass.getText().toString().isEmpty()) {
                    TextView tv = findViewById(R.id.incorrectmail);
                    tv.setText("You must confirm your password");
                    return;

                }
                else if (!pass.getText().toString().equals(confirmPass.getText().toString()) ){
                    TextView tv = findViewById(R.id.incorrectmail);
                    tv.setText("Passwords must be same");
                    return;
                }
                gender = findViewById(R.id.gender);
                if (gender.getCheckedRadioButtonId() == -1 ){
                    TextView tv = findViewById(R.id.incorrectmail);
                    tv.setText("You must select a gender");
                    return;
                }

                Intent intent = new Intent(signUp.this, homePage.class);

                intent.putExtra("UserName", uname.getText().toString());
                startActivity(intent);

            }
        });
    }

}
