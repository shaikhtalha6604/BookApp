package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.bookapp.model.Book;
import com.example.bookapp.recyclerview.BookAdapter;
import com.example.bookapp.recyclerview.IBookListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IBookListener {

    List<Book> books;
    RecyclerView rvBooks;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        initBooks();
        SetupBookAdapter();
    }

    private void SetupBookAdapter() {
        bookAdapter = new BookAdapter(books, this);
        rvBooks.setAdapter(bookAdapter);
    }

    private void initBooks() {
        books = new ArrayList<>();
        books.add(new Book("Nursery1", "By Unknown", "122 Pages", R.drawable.nursery1));
        books.add(new Book("A Place Called Perfect", "By Helena Duggan", "250 Pages", R.drawable.book1));
        books.add(new Book("Slay Bells", "By T.C. Wescott", "250 Pages", R.drawable.book2));
        books.add(new Book("Boneless Mercies", "By Laini Taylor", "250 Pages", R.drawable.book3));
        books.add(new Book("Five Feet Apart", "By Rachael Lippincott", "250 Pages", R.drawable.book4));
        books.add(new Book("The Work Of Art", "By Alison Gerber", "250 Pages", R.drawable.book5));
        books.add(new Book("The Girl Of Ink And Stars", "By Kiran Millhood Hargrave", "250 Pages", R.drawable.book6));
    }

    private void initRecyclerView() {
        rvBooks = findViewById(R.id.rvBooks);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        rvBooks.setHasFixedSize(true);
    }

    @Override
    public void OnItemClick(int Position) {

        String bookName = books.get(Position).get_title();
        Intent intent = new Intent(this, BookActivity.class);
        intent.putExtra("NAME", bookName);
        startActivity(intent);
    }

    @Override
    public void OnItemLongClick(int Position) {

    }
}