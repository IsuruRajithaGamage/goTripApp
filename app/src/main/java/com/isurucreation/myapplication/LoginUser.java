package com.isurucreation.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.widget.Toast.LENGTH_SHORT;

public class LoginUser extends AppCompatActivity {

    EditText emailID, password;
    Button sign, btnsignin;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        mAuth = FirebaseAuth.getInstance();
        mAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.getemail);
        password = findViewById(R.id.getpassword);
        btnsignin = findViewById(R.id.btnsignin);

        mAuthStateListner = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LoginUser.this, "You are Logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginUser.this, welcomeScreen.class);
                    startActivity(i);

                } else {
                    Toast.makeText(LoginUser.this, "Please Login", Toast.LENGTH_SHORT).show();

                }
            }
        };
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailID.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailID.setError("please enter email");
                    emailID.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("please check your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(LoginUser.this, "Fields are empty", LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginUser.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginUser.this, "Login Again", LENGTH_SHORT).show();
                            } else {
                                Intent intHome = new Intent(LoginUser.this, welcomeScreen.class);
                                startActivity(intHome);
                            }
                        }

                    });
                } else {
                    Toast.makeText(LoginUser.this, "Error Occurred", LENGTH_SHORT).show();

                }
            }
        });

    }
    public void gosign(View view) {
        Intent intent = new Intent(LoginUser.this, SignupUser.class);
        startActivity(intent);
    }

}