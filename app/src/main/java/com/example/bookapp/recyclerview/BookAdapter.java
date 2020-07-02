package com.example.bookapp.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.bookapp.R;
import com.example.bookapp.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    List<Book> books;
    IBookListener iBookListener;

    public BookAdapter(List<Book> books, IBookListener iBookListener) {
        this.books = books;
        this.iBookListener = iBookListener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
         .inflate(R.layout.item_book, parent, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, final int position) {

        Book book = books.get(position);

        Glide.with(holder.itemView.getContext())
                .load(book.get_imgResources())
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(holder._bookImg);
        holder._title.setText(book.get_title());
        holder._author.setText(book.get_author());
        holder._pages.setText(book.get_pages());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookViewHolder extends  RecyclerView.ViewHolder{

        ImageView _bookImg;
        TextView _title,_author, _description, _pages;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            _bookImg = itemView.findViewById(R.id.item_book_img);
            _title = itemView.findViewById(R.id.item_book_title);
            _author = itemView.findViewById(R.id.item_book_author);
            _pages = itemView.findViewById(R.id.item_book_pages);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iBookListener.OnItemClick(getAdapterPosition());
                }
            });
        }
    }
}
