package com.example.bookapp.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bookapp.BookActivity;
import com.example.bookapp.MainActivity;
import com.example.bookapp.R;
import com.example.bookapp.database.SessionManager;

import java.util.HashMap;

public class StudentDashboard extends AppCompatActivity {

    TextView studentName;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        initUI();

        SessionManager sessionManager = new SessionManager(this, SessionManager.SESSION_USERSESSION);
        if (sessionManager.CheckLogin()){
            HashMap<String, String> userDetails = sessionManager.GetUserDetailsFromSession();
            studentName.setText(userDetails.get(SessionManager.KEY_USERNAME));
        }

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToAllBooks();
            }
        });
    }

    void initUI(){
        studentName = findViewById(R.id.studentName);
        cardView = findViewById(R.id.all_books);
    }

    void ToAllBooks(){
        startActivity(new Intent(StudentDashboard.this, MainActivity.class));
    }
}