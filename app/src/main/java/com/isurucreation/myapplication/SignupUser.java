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

import static android.widget.Toast.LENGTH_SHORT;

public class SignupUser extends AppCompatActivity {
    EditText emailID,password;
    Button sign,btnnew;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);

        mAuth = FirebaseAuth.getInstance();

        mAuth =FirebaseAuth.getInstance();
        emailID=findViewById(R.id.editText);
        password= findViewById(R.id.editText2);
        sign= findViewById(R.id.btnsignup);
        // btnnew = findViewById(R.id.btnnew);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailID.getText().toString();
                String pwd=password.getText().toString();
                if(email.isEmpty()){
                    emailID.setError("please enter email");
                    emailID.requestFocus();
                }else if (pwd.isEmpty()){
                    password.setError("please check your password");
                    password.requestFocus();
                }else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SignupUser.this,"Fields are empty", LENGTH_SHORT).show();
                }else if(!(email.isEmpty() && pwd.isEmpty())){
                    mAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(SignupUser.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SignupUser.this,"TryAgain", LENGTH_SHORT).show();

                            }else {

                                //startActivity(new Intent(signup.this,afterLog.class));
                                Intent ha = new Intent(SignupUser.this,welcomeScreen.class);
                                startActivity(ha);
                            }
                        }
                    });
                }else{
                    Toast.makeText(SignupUser.this,"Error Occurred", LENGTH_SHORT).show();
                }
            }
        });
    }
    public void gologin(View view) {
        Intent n = new Intent(SignupUser.this,LoginUser.class);
        startActivity(n);
    }
}