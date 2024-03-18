package service;

import model.DataBase;
import model.Library;

import java.util.List;

public interface LibraryService {
    List<Library> saveLibrary(List<Library> libraries, DataBase dataBase);

    List<Library>getAllLibraries(DataBase dataBase);

    Library getLibraryById(Long id,DataBase dataBase);

    Library updateLibrary(Long id,DataBase dataBase);

    String deleteLibrary(Long id,DataBase dataBase);


}
