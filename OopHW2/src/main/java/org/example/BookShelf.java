package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Написать программу - реализацию книжного шкафа в библиотеке.
        * Должны иметь возможность добавлять \ удалять книги.
        * Узнать кол-во книг
        * При запросе сообщить есть ли такая книга у нас или нет
        * Делаем с принципом инкапсуляции. Используем геттеры, сеттеры, конструкторы
*/
public class BookShelf {
    private String genre;
    protected String letter;
    static int capacity;
    private static List<Book> shelf = new ArrayList<>();

    public BookShelf(String genre, String letter, int capacity) {
        this.genre = genre;
        this.letter = letter;
        this.capacity = capacity;
    }

    public static void findByAuthor(String value) {
        for (Book book: shelf) {
            if (book.getAuthor().equals(value)) {
                System.out.println(book);
            }
        }
    }
    public static void findByName(String value) {
        for (Book book: shelf) {
            if (book.getName().equals(value)) {
                System.out.println(book);
            }
        }
    }
    public static void findAll() {
        int count = 0;
        for (Book book: shelf) {
            System.out.println(book);
            count++;
        }
        System.out.println("Всего " + count + " книг");
    }
    public void addBook(Book book) {
        if (shelf.size() < capacity) {
            shelf.add(book);
        }
    }
    public static void addNewBook() {
        Scanner sc = new Scanner(System.in);
        if (shelf.size() < 10) {
            Book book = new BookBuilder().builder()
                    .setAuthor(sc.nextLine())
                    .setName(sc.nextLine())
                    .setYear(sc.nextInt())
                    .build();
            shelf.add(book);
            capacity -= 1;
        } else {
            System.out.println("Шкаф полон");
        }
    }
    public static void removeBook(String value) {
        for (int i = 0; i < shelf.size(); i++) {
            if (shelf.get(i).getName().equals(value) || shelf.get(i).getAuthor().equals(value)) {
                shelf.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "BookShelf{" +
                "genre='" + genre + '\'' +
                ", letter='" + letter + '\'' +
                ", capacity=" + capacity +
                ", shelf=" + shelf +
                '}';
    }

    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}
    public String getLetter() {return letter;}
    public void setLetter(String letter) {this.letter = letter;}
    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

}
