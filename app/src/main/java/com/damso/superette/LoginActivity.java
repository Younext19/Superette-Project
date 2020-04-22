package com.damso.superette;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.damso.superette.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    EditText UserEmail;
    EditText UserPassword;
    Button LoginButton;
    DatabaseHelper db;
    TextView NewAccountLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Initialise();
        db = new DatabaseHelper(this);


        NewAccountLink = findViewById(R.id.register_acc);
        NewAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToRegisterActivity();
            }
        });
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = UserEmail.getText().toString();
                String Pw = UserPassword.getText().toString();
                Boolean checkmailpw = db.emailpassword(email, Pw);
                if(checkmailpw == true){
                    //RESLAH LEL MAIN
                    Toast.makeText(getApplicationContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    SendUserToMainActivity();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Email Or Password", Toast.LENGTH_SHORT).show();
                }


            }
        });

        // HADI HNA LEWLA
    }
    private void Initialise() {
        LoginButton=findViewById(R.id.submit);
        UserEmail = findViewById(R.id.loginmail);
        UserPassword = findViewById(R.id.login_password);


    }

    private void SendUserToMainActivity() {
        Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
        MainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(MainIntent);
        finish();

    }

    //____________GO TO Register ACTIVITY_____________________
    private void SendUserToRegisterActivity() {

        Intent RegisterIntent = new Intent(LoginActivity.this, Register_Activity.class);
        startActivity(RegisterIntent);
    }

}