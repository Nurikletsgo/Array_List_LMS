import model.GeneratedId;
import model.Reader;
import service.BookService;
import service.LibraryService;
import service.ReaderService;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        LibraryServiceImpl libraryService = new LibraryServiceImpl();

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
                        libraryService.getLibraryMenu();
                        break;
                    case 2:
                        bookService.getBookMenu();
                        break;
                    case 3:
                        readerService.getReaderMenu();
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println(" choose only number 1-2-3-4");
                }
            } catch (Exception e) {
                System.err.println("Write again");
            }
        }
    }
}