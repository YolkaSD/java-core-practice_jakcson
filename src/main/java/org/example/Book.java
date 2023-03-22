package org.example;

public class Book {
    private String title;
    private String author;
    private String published;

    public Book() {
    }

    public Book(String title, String author, String published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublished() {
        return published;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublished(String published) {
        this.published = published;
    }
}
