package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BookShelf engShelf = new BookShelf("Other", "O", 10);
        BookShelf tShelf = new BookShelf("Russian literature", "T", 10);
        BookShelf dShelf = new BookShelf("Russian literature", "D", 10);
        Book book1 = new Book("Tolstoy Leo", "War and peace", 1869);
        Book book2 = new Book("Tolstoy Leo", "Anna Karenina", 1878);
        Book book3 = new Book("Tolstoy Leo", "Family Happiness", 1859);
        Book book4 = new Book("Dostoyevsky Fyodor", "The Idiot", 1869);
        Book book5 = new Book("Dostoyevsky Fyodor", "Crime and Punishment", 1866);
        Book book6 = new Book("Dostoyevsky Fyodor", "The Brothers Karamazov", 1880);
        Book b1 = new Book("Lewis Carroll","Alice in Wonderland", 1865);
        Book b2 = new Book("P. J. Travers","Mary Poppins", 1934);

        tShelf.addBook(book1);
        tShelf.addBook(book2);
        tShelf.addBook(book3);

        dShelf.addBook(book4);
        dShelf.addBook(book5);
        dShelf.addBook(book6);

        engShelf.addBook(b1);
        engShelf.addBook(b2);

        System.out.println("1. Поиск по автору\n" +
                "2. Поиск по названию книги\n" +
                "3. Вывести все книги\n" +
                "4. Удалить книгу\n" +
                "5. Добавить книгу\n");
        choice();
        System.out.println();

    }
    public static void choice() {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();

        switch (value) {
            case "1" -> {
                System.out.println("Укажите имя автора");
                value = sc.nextLine();
                BookShelf.findByAuthor(value);
            }
            case "2" -> {
                System.out.println("Укажите название книги");
                value = sc.nextLine();
                BookShelf.findByName(value);
            }
            case "3" -> BookShelf.findAll();
            case "4" -> {
                System.out.println("Укажите название книги, которую желаете удалить");
                value = sc.nextLine();
                BookShelf.removeBook(value);
                BookShelf.findAll();
            }
            case "5" -> {
                System.out.println("Укажите параметры книги");
                BookShelf.addNewBook();
                BookShelf.findAll();
            }
        }
    }
}