package com.example.cia.esuratuser;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cia.esuratuser.helper.Config;
import com.example.cia.esuratuser.rule.HomeKelurahanActivity;
import com.example.cia.esuratuser.rule.HomeRTActivity;
import com.example.cia.esuratuser.rule.HomeUserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    Button btnLogin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = (EditText)findViewById(R.id.edt_email);
        edtPassword = (EditText)findViewById(R.id.edt_password);
        btnLogin = (Button)findViewById(R.id.btn_login);
        firebaseAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Please Wait ...", "Processing", true);

                firebaseAuth.signInWithEmailAndPassword(edtEmail.getText().toString(), edtPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                //if (task.isSuccessful()){
                                if (edtEmail.getText().toString().equals("user@gmail.com")) {


                                    //Creating a shared preference
                                    SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                    //Creating editor to store values to shared preferences
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    //Adding values to editor
                                    editor.putBoolean(Config.LOGGEDIN_SHARED_PREF           , true);
                                    editor.putString(Config.LOGIN_ID_SHARED_PREF            , "1");
                                    editor.putString(Config.LOGIN_EMAIL_SHARED_PREF         , edtEmail.getText().toString().trim());
                                    editor.putString(Config.LOGIN_RULE_SHARED_PREF          , "user");
                                    //Saving values to editor
                                    editor.commit();
                                    Intent i = new Intent(LoginActivity.this, HomeUserActivity.class);
                                    startActivity(i);
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    finish();

                                }
                                else if (edtEmail.getText().toString().equals("rt@gmail.com")) {
                                    //Creating a shared preference
                                    SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                    //Creating editor to store values to shared preferences
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    //Adding values to editor
                                    editor.putBoolean(Config.LOGGEDIN_SHARED_PREF           , true);
                                    editor.putString(Config.LOGIN_ID_SHARED_PREF            , "1");
                                    editor.putString(Config.LOGIN_EMAIL_SHARED_PREF         , edtEmail.getText().toString().trim());
                                    editor.putString(Config.LOGIN_RULE_SHARED_PREF          , "user");
                                    //Saving values to editor
                                    editor.commit();
                                    Intent i = new Intent(LoginActivity.this, HomeRTActivity.class);
                                    startActivity(i);
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    finish();

                                }
                                else if (edtEmail.getText().toString().equals("kelurahan@gmail.com")) {
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    //Creating a shared preference
                                    SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                    //Creating editor to store values to shared preferences
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    //Adding values to editor
                                    editor.putBoolean(Config.LOGGEDIN_SHARED_PREF           , true);
                                    editor.putString(Config.LOGIN_ID_SHARED_PREF            , "1");
                                    editor.putString(Config.LOGIN_EMAIL_SHARED_PREF         , edtEmail.getText().toString().trim());
                                    editor.putString(Config.LOGIN_RULE_SHARED_PREF          , "user");
                                    //Saving values to editor
                                    editor.commit();
                                    Intent i = new Intent(LoginActivity.this, HomeKelurahanActivity.class);
                                    startActivity(i);
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    finish();

                                }else {
                                    Log.e("Error", task.getException().toString());
                                    Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
