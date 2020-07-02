package com.example.bookapp.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bookapp.BookActivity;
import com.example.bookapp.MainActivity;
import com.example.bookapp.R;

public class StudentDashboard extends AppCompatActivity {

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        initUI();

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToAllBooks();
            }
        });
    }

    void initUI(){
        cardView = findViewById(R.id.all_books);
    }

    void ToAllBooks(){
        startActivity(new Intent(StudentDashboard.this, MainActivity.class));
    }
}