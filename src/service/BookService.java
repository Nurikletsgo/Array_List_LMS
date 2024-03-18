package service;

import model.Book;
import model.DataBase;

import java.util.List;

public interface BookService {
    Book saveBook(Long libraryId, Book book, DataBase dataBase);

    List<Book> getAllBooks(Long libraryId,DataBase dataBase);

    Book getBookById(Long libraryId, Long bookId,DataBase dataBase);

    String deleteBook(Long libraryId,Long bookId,DataBase dataBase);

    void clearBooksByLibraryId(Long libraryId,DataBase dataBase);


}
