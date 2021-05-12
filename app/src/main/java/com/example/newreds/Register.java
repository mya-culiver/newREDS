package com.example.newreds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity {


    EditText mFullName, mEmail, mPassword;
    Button btnRegister1;
    TextView goLogin;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.etFullName);
        mEmail = findViewById(R.id.etEmail);
        mPassword = findViewById(R.id.etPassword);
        btnRegister1 = findViewById(R.id.btnRegister1);
        goLogin = findViewById(R.id.textView2);
        fAuth = FirebaseAuth.getInstance();


        btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("Password too short");
                    return;
                }


                // register user in firebase

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent (getApplicationContext(), Accounts.class));
                        } else {
                            Toast.makeText(Register.this, "ERROR" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getApplicationContext(), Login.class));
            }
        });


    }
}