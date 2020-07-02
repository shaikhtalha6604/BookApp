package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;

import com.github.barteksc.pdfviewer.PDFView;

public class BookActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        pdfView = findViewById(R.id.pdfView);

        String bookName = getIntent().getStringExtra("NAME");

        LoadPDF(bookName);
    }

    void LoadPDF(String bookName){

        if (bookName.equals("Nursery1")){
            pdfView.fromAsset(bookName + ".pdf").load();
        }else {
            pdfView.fromAsset("sound.pdf")
                    .swipeHorizontal(true)
                    .pageSnap(true)
                    .autoSpacing(true)
                    .pageFling(true)
                    .load();
        }
    }
}