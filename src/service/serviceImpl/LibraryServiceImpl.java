package service.serviceImpl;

import model.DataBase;
import model.GeneratedId;
import model.Library;
import service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryServiceImpl implements LibraryService {

    public void getLibraryMenu(){
        boolean choose = true;
        while (choose){
            System.out.println("""
                    1. Add library
                    2. Get all libraries
                    3. Get library by ID
                    4. Update library
                    5. Delete library
                    6. Exit""");
            try {
                switch (new Scanner(System.in).nextInt()){
                    case 1:
                        Library library = new Library();
                        library.setLibraryId(GeneratedId.getLibraryId());
                        library.setName();
                        List<Library> libraries = new ArrayList<>();
                        libraries.add(library);
                        saveLibrary(libraries);
                        System.out.println("Successfully added");
                        break;
                    case 2:
                        System.out.println(getAllLibraries());
                        break;
                    case 3:
                        System.out.println("write library ID ");
                        System.out.println(getLibraryById(new Scanner(System.in).nextLong()));
                        break;
                    case 4:
                        Library library1 = new Library();
                        System.out.println("write library ID which you want to update");
                        Long libID = new Scanner(System.in).nextLong();
                        System.out.println("write new library information ");
                        library1.setLibraryId(libID);
                        library1.setName();
                        System.out.println(updateLibrary(libID, library1));
                        break;
                    case 5:
                        System.out.println("write library ID which you want to deleted");
                        System.out.println(deleteLibrary(new Scanner(System.in).nextLong()));
                        break;
                    case 6: choose = false;
                    break;
                    default:
                        System.err.println("choose only number 1-2-3-4-5-6 ");
                }
            }catch (Exception e){
                System.err.println("write again (Exception)");
            }
        }
    }
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        DataBase.libraries.addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return DataBase.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        Library newLibrary = new Library();
        for (Library library : DataBase.libraries) {
            if(library.getLibraryId().equals(id)){
                newLibrary = library;
            }
        }
        return newLibrary;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (Library library1 : DataBase.libraries) {
            if (library1.getLibraryId().equals(id)){
                DataBase.libraries.set(Math.toIntExact(id),library);
            }
        }
        return library;
    }

    @Override
    public String deleteLibrary(Long id) {
        String word = null;
        for (Library library : DataBase.libraries) {
            if (library.getLibraryId().equals(id)){
                DataBase.libraries.remove(library);
                word = "Successfully deleted";
                break;
            }else {
                System.err.println("ID not found");
                break;
            }

        }
        return word;
    }
}
