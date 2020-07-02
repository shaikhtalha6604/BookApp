package com.example.bookapp.model;

public class Book {
    private  String _title, _author, _description,_pages;
    private  int _imgResources;

    public Book() {
    }

    public Book(String _title, String _author, String _pages, int _imgResources) {
        this._title = _title;
        this._author = _author;
        this._pages = _pages;
        this._imgResources = _imgResources;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_author() {
        return _author;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public int get_imgResources() {
        return _imgResources;
    }

    public void set_imgResources(int _imgResources) {
        this._imgResources = _imgResources;
    }

    public String get_pages() {
        return _pages;
    }

    public void set_pages(String _pages) {
        this._pages = _pages;
    }
}
