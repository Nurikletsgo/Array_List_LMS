import model.*;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        LibraryServiceImpl libraryService = new LibraryServiceImpl();


        Library library1 = (new Library(GeneratedId.getLibraryId(), "Chyngyz Aitmatov", "Manas 13", new ArrayList<>(), new ArrayList<>()));
        Library library2 = (new Library(GeneratedId.getLibraryId(), "Kasymaaly Baylinov", "Chyi 227", new ArrayList<>(), new ArrayList<>()));
        Library library3 = (new Library(GeneratedId.getLibraryId(), "Alykul Osmonov", "Sovetskyi 13", new ArrayList<>(), new ArrayList<>()));
        List<Library> libraries = Arrays.asList(library1,library2,library3);
        while (true) {
            System.out.println("""
                    1. Library
                    2. Book
                    3. Reader
                    4. exit
                    """);
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        boolean choose = true;
                        while (choose) {
                            System.out.println("""
                                    1. Add library
                                    2. Get all libraries
                                    3. Get library by ID
                                    4. Update library
                                    5. Delete library
                                    6. Exit""");
                            try {
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1:
                                        libraryService.saveLibrary(libraries, dataBase);
                                        System.out.println("library successfully added");
                                        break;
                                    case 2:
                                        System.out.println(libraryService.getAllLibraries(dataBase));
                                        break;
                                    case 3:
                                        System.out.println("write library ID ");
                                        System.out.println(libraryService.getLibraryById(new Scanner(System.in).nextLong(), dataBase));
                                        break;
                                    case 4:
                                        System.out.println("write library ID which you want to update");
                                        Long libID = new Scanner(System.in).nextLong();
                                        System.out.println(libraryService.updateLibrary(libID, dataBase));
                                        break;
                                    case 5:
                                        System.out.println("write library ID which you want to deleted");
                                        Long libId = new Scanner(System.in).nextLong();
                                        System.out.println(libraryService.deleteLibrary(libId, dataBase));
                                        break;
                                    case 6:
                                        choose = false;
                                        break;
                                    default:
                                        System.err.println("choose only number 1-2-3-4-5-6 ");
                                }
                            } catch (Exception e) {
                                System.err.println("write again (Exception main Library)");
                            }
                        }
                        break;
                    case 2:
                        boolean choice = true;
                        while (choice) {
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
                                        dataBase.getBooks().add(bookService.saveBook(libraryId, book, dataBase));
                                        System.out.println("successfully added");
                                        break;
                                    case 2:
                                        System.out.println("write library ID ");
                                        System.out.println(bookService.getAllBooks(new Scanner(System.in).nextLong(), dataBase));
                                        break;
                                    case 3:
                                        System.out.println(" write Library ID ");
                                        Long libraryId1 = new Scanner(System.in).nextLong();
                                        System.out.println("write book ID which you want to get");
                                        Long bookId1 = new Scanner(System.in).nextLong();
                                        System.out.println(bookService.getBookById(libraryId1, bookId1, dataBase));
                                        break;
                                    case 4:
                                        System.out.println(" write Library ID");
                                        Long libraryId2 = new Scanner(System.in).nextLong();
                                        System.out.println(" write book ID which you want to delete");
                                        Long bookId = new Scanner(System.in).nextLong();
                                        System.out.println(bookService.deleteBook(libraryId2, bookId, dataBase));
                                        break;
                                    case 5:
                                        System.out.println("write library ID which you want to delete all books");
                                        bookService.clearBooksByLibraryId(new Scanner(System.in).nextLong(), dataBase);
                                        break;
                                    case 6:
                                        choice = false;
                                        break;
                                    default:
                                        System.err.println("choose only number 1-2-3-4-5-6 ");

                                }
                            } catch (Exception e) {
                                System.err.println("write again (Exception main book)");
                            }
                        }
                        break;
                    case 3:
                        boolean option = true;
                        while (option) {
                            System.out.println("""
                                    1. Add reader
                                    2. Get all reader
                                    3. Get reader by ID
                                    4. Update reader
                                    5. Assign reader to library
                                    6. exit""");
                            try {
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1:
                                        Reader reader = new Reader();
                                        reader.setId(GeneratedId.getReaderId());
                                        reader.setFullName();
                                        reader.setEmail();
                                        reader.setPhoneNumber();
                                        reader.setGender();
                                        readerService.saveReader(reader, dataBase);
                                        break;
                                    case 2:
                                        System.out.println(readerService.getAllReaders(dataBase));
                                        break;
                                    case 3:
                                        System.out.println("write reader ID");
                                        System.out.println(readerService.getReaderById(new Scanner(System.in).nextLong(), dataBase));
                                        break;
                                    case 4:
                                        System.out.println("write reader ID which you want to update ");
                                        Long ID = new Scanner(System.in).nextLong();
                                        System.out.println(readerService.updateReader(ID, dataBase));
                                        break;
                                    case 5:
                                        System.out.println("write reader ID which you want ");
                                        Long readerId = new Scanner(System.in).nextLong();
                                        System.out.println("write library ID");
                                        Long libraryId = new Scanner(System.in).nextLong();
                                        readerService.assignReaderToLibrary(readerId, libraryId, dataBase);
                                        break;
                                    case 6:
                                        option = false;
                                        break;
                                    default:
                                        System.err.println("choose only number 1-2-3-4-5-6 ");
                                }
                            } catch (Exception e) {
                                System.err.println("write again (Exception main reader)");
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println(" choose only number 1-2-3-4");
                }
            } catch (Exception e) {
                System.err.println("Write again (Exception main)");
            }
        }
    }
}