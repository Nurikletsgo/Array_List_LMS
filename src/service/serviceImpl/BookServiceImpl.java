package service.serviceImpl;

import model.Book;
import model.DataBase;
import model.GeneratedId;
import model.Library;
import service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {

    public void getBookMenu() {
        boolean choose = true;
        while (choose) {
            System.out.println("""
                    1. Add book
                    2. Get all books
                    3. Get book by ID
                    4. Delete book
                    5. Clear books by library ID
                    6. exit""");
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        Book book = new Book();
                        book.setBookId(GeneratedId.getBookId());
                        book.setName();
                        book.setAuthorName();
                        book.setGenre();
                        System.out.println(book);
                        System.out.println("write library ID which you want to save your book");
                        Long libraryId = new Scanner(System.in).nextLong();
                        saveBook(libraryId, book);
                        System.out.println("successfully added");
                        break;
                    case 2:
                        System.out.println("write library ID ");
                        System.out.println(getAllBooks(new Scanner(System.in).nextLong()));
                        break;
                    case 3:
                        System.out.println(" write Library ID ");
                        Long libraryId1 = new Scanner(System.in).nextLong();
                        System.out.println("write book ID which you want to get");
                        Long bookId1 =  new Scanner(System.in).nextLong();
                        getBookById(libraryId1,bookId1);
                        break;
                    case 4:
                        System.out.println(" write Library ID");
                        Long libraryId2 = new Scanner(System.in).nextLong();
                        System.out.println(" write book ID which you want to delete");
                        Long bookId =  new Scanner(System.in).nextLong();
                        deleteBook(libraryId2,bookId);
                        break;
                    case 5:
                        System.out.println("write library ID which you want to delete all books");
                        clearBooksByLibraryId(new Scanner(System.in).nextLong());
                        break;
                    case 6:
                        choose = false;
                        break;
                    default:
                        System.err.println("choose only number 1-2-3-4-5-6 ");

                }
            } catch (Exception e) {
                System.err.println("write again (Exception)");
            }
        }
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : DataBase.libraries) {
            if (library.getLibraryId() == (libraryId)) {
                DataBase.books.add(book);
                library.setBooks(book);
            }
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library : DataBase.libraries) {
            if (library.getLibraryId().equals(libraryId)) {
                return DataBase.books;
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Book newBook = new Book();
        for (Library library : DataBase.libraries) {
            if (library.getLibraryId().equals(libraryId)) {
                for (Book book : library.getBooks()) {
                    if (book.getBookId().equals(bookId)) {
                        newBook = book;
                    }
                }
            }
        }
        return newBook;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        String word = null;
        for (Library library : DataBase.libraries) {
            if (library.getLibraryId().equals(libraryId)) {
                for (Book book : library.getBooks()) {
                    if (bookId.equals(book.getBookId())) {
                        library.getBooks().remove(book);
                        word = "successfully deleted";
                        break;
                    }
                }
            }
        }

        return word;
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : DataBase.libraries) {
            if (library.getLibraryId().equals(libraryId)) {
                library.getBooks().clear();
                System.out.println("Books in this library successfully deleted (clear)");
                break;
            } else {
                System.err.println("library not found");
                break;
            }
        }
    }

}