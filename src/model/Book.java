package model;

import model.enums.Genre;

import java.util.Arrays;
import java.util.Scanner;

public class Book {
    private Long bookId;
    private String name;
    private String authorName;
    private Genre genre;

    public Book() {
    }

    public Book(Long bookId, String name, String authorName, Genre genre) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.genre = genre;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        boolean choose = true;
        System.out.println("write book name");
        while (choose) {
            try {

                this.name = new Scanner(System.in).nextLine();
                choose = false;
            }
            catch (Exception e) {
                System.err.println("write letter");
            }
        }
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName() {
        boolean choose = true;
        System.out.println("write book's author  name");
        while (choose) {
            try {
                this.authorName = new Scanner(System.in).nextLine();
                choose = false;
            }
            catch (Exception e) {
                System.err.println("write letter");
            }
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre() {
        boolean choose = true;
        System.out.println("Write book genre  "+ Arrays.toString(Genre.values()));
        while (choose) {
            try {
                this.genre = Genre.valueOf(new Scanner(System.in).nextLine());
                choose = false;
            } catch (Exception e) {
                System.err.println("write book genre");
            }
        }
    }

    @Override
    public String toString() {
        return "\n { " +
                "book ID = " + bookId +
                ", name = '" + name + '\'' +
                ", author name = '" + authorName + '\'' +
                ", genre = " + genre +
                '}';
    }
}
