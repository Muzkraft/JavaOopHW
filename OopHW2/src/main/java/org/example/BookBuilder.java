package org.example;

public class BookBuilder {
    private Book book;

    public BookBuilder builder(){
        book = new Book();
        return this;
    }
    public BookBuilder setAuthor(String author){
        this.book.setAuthor(author);
        return this;
    }
    public BookBuilder setName(String name){
        this.book.setName(name);
        return this;
    }

    public BookBuilder setYear(int year){
        this.book.setYear(year);
        return this;
    }

    public Book build(){
        return book;
    }
}
