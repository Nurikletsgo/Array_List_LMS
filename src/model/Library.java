package model;

import java.util.List;
import java.util.Scanner;

public class Library {
    private Long libraryId;
    private String name;
    private List<Book> books;
   private List<Reader> readers;

    public Library() {
    }

    public Library(Long libraryId, String name) {
        this.libraryId = libraryId;
        this.name = name;
    }

    public Library(Long libraryId, String name, List<Book> books, List<Reader> readers) {
        this.libraryId = libraryId;
        this.name = name;
        this.books = books;
        this.readers = readers;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }



    public String getName() {
        return name;
    }

    public void setName() {
        boolean choose = true;
        System.out.println("write library name");
        while (choose) {
            try {
                this.name = new Scanner(System.in).nextLine();
                choose = false;
            } catch (Exception e) {
                System.err.println("write letter");
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book book) {
        this.books.add(book);
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "\n{ " +
                "library ID = " + libraryId +
                ", library name = '" + name + '\'' +
                ", \nbooks = " + books +
                ", \nreaders = " + readers +
                '}';
    }
}
