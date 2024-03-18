package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private Long libraryId;
    private String name;
    private String address;
    private List<Book> books = new ArrayList<>();
   private List<Reader> readers = new ArrayList<>();

    public Library() {
    }

    public Library(Long libraryId, String name, String address, List<Book> books, List<Reader> readers) {
        this.libraryId = libraryId;
        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        boolean choose = true;
        System.out.println("write library address");
        while (choose) {
            try {
                this.address = new Scanner(System.in).nextLine();
                choose = false;
            } catch (Exception e) {
                System.err.println("write letter");
            }
        }
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

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return " \n Library { " +
                " libraryId = " + libraryId +
                ", name = '" + name + '\'' +
                ", address = '" + address + '\'' +
                ", \nbooks = " + books +
                ", \nreaders = " + readers +
                '}';
    }
}
