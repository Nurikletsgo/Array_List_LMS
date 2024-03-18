package service.serviceImpl;

import model.DataBase;
import model.Library;
import service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryServiceImpl implements LibraryService {



    @Override
    public List<Library> saveLibrary(List<Library> libraries,DataBase dataBase) {
        dataBase.getLibraries().addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries(DataBase dataBase) {
        return dataBase.getLibraries();
    }

    @Override
    public Library getLibraryById(Long id,DataBase dataBase) {
        for (Library library : dataBase.getLibraries()) {
            if (library.getLibraryId().equals(id)) {
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id,DataBase dataBase) {
        for (Library library : dataBase.getLibraries()) {
            if (library.getLibraryId().equals(id)) {
                System.out.println("write new library information ");
                library.setLibraryId(id);
                library.setName();
                library.setAddress();
                return library;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id,DataBase dataBase) {
        for (Library library : dataBase.getLibraries()) {
            if (id == (library.getLibraryId())) {
                dataBase.getLibraries().remove(library);
                return "Successfully deleted";
            }

        }
        return "not found";
    }
}
