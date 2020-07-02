package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;

public class BookActivity extends AppCompatActivity {

    PDFView pdfView;
    PageCurlView pageCurlView;

    List<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        pdfView = findViewById(R.id.pdfView);
        pageCurlView = findViewById(R.id.pageCurlView);
        images = new ArrayList<>();

        String bookName = getIntent().getStringExtra("NAME");

        AddImagesToList(bookName);
        //LoadPDF(bookName);
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

    void AddImagesToList(String bookName){

        if (bookName.equals("Nursery1")){
            images.add(R.drawable.nur1);
            images.add(R.drawable.nur2);
            images.add(R.drawable.nur3);
            images.add(R.drawable.nur4);
            images.add(R.drawable.nur5);

            pageCurlView.setCurlView(images);
            pageCurlView.setCurlSpeed(600);
        }else {
            pdfView.fromAsset("nursery1.pdf")
                    .swipeHorizontal(true)
                    .pageSnap(true)
                    .autoSpacing(true)
                    .pageFling(true)
                    .load();
        }
    }
}