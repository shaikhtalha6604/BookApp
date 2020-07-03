package com.example.bookapp.loginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookapp.MainActivity;
import com.example.bookapp.R;
import com.example.bookapp.dashboard.AdminDashboard;
import com.example.bookapp.dashboard.StudentDashboard;
import com.example.bookapp.database.SessionManager;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btn_login;
    CheckBox rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();

        SessionManager sessionManager = new SessionManager(Login.this, SessionManager.SESSION_REMEMBERME);
        if (sessionManager.CheckRememberMe()){
            HashMap<String,String> rememberMeDetails = new HashMap<>();
            username.setText(rememberMeDetails.get(SessionManager.KEY_SESSIONUSERNAME));
            password.setText(rememberMeDetails.get(SessionManager.KEY_SESSIONPASSWORD));
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToMainScreen();
            }
        });
    }

    void initUI() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        rememberMe = findViewById(R.id.remember_me);
    }

    void ToMainScreen(){
        String _username = username.getText().toString().trim();
        String _pass = password.getText().toString().trim();

        if (rememberMe.isChecked()){
            SessionManager sessionManager = new SessionManager(Login.this, SessionManager.SESSION_REMEMBERME);
            sessionManager.CreateRememberMeSession(_username, _pass);
        }

        if (_username.equals("admin") && _pass.equals("pass123"))
            startActivity(new Intent(this, AdminDashboard.class));
        else if (_username.equals("student") && _pass.equals("pass123"))
            startActivity(new Intent(this, StudentDashboard.class));
        else
            startActivity(new Intent(this, MainActivity.class));
    }
}