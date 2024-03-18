package service.serviceImpl;

import model.Book;
import model.DataBase;
import model.Library;
import service.BookService;
import java.util.List;

public class BookServiceImpl  implements BookService {


    @Override
    public Book saveBook(Long libraryId, Book book,DataBase dataBase) {
        for (Library library : dataBase.getLibraries()) {
            if (library.getLibraryId()==(libraryId)) {
                library.getBooks().add(book);
            }
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId,DataBase dataBase) {
        for (Library library : dataBase.getLibraries()) {
            if (library.getLibraryId().equals(libraryId)) {
                return library.getBooks();

            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId,DataBase dataBase) {
        for (Library library : dataBase.getLibraries()) {
            if (library.getLibraryId().equals(libraryId)) {
                for (Book book : library.getBooks()) {
                    if (book.getBookId().equals(bookId)) {
                       return   book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId,DataBase dataBase) {
        for (Library library : dataBase.getLibraries()) {
            if (library.getLibraryId().equals(libraryId)) {
                for (Book book : library.getBooks()) {
                    if (bookId.equals(book.getBookId())) {
                        library.getBooks().remove(book);
                        return "successfully deleted";
                    }
                }
            }
        }

        return null;
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId,DataBase dataBase) {
        for (Library library : dataBase.getLibraries()) {
            if (library.getLibraryId().equals(libraryId)) {
                library.getBooks().clear();
                System.out.println("Books in this library successfully deleted (clear)");
            } else {
                System.err.println("library not found");
            }
            break;
        }
    }

}