package service;

import model.DataBase;
import model.Reader;

import java.util.List;

public interface ReaderService {
    void saveReader(Reader reader, DataBase dataBase);
    List<Reader> getAllReaders(DataBase dataBase);

    Reader getReaderById(Long id,DataBase dataBase);

    Reader updateReader(Long id,DataBase dataBase);

    void assignReaderToLibrary(Long readerId,Long libraryId,DataBase dataBase);
}
