package service.serviceImpl;

import model.DataBase;
import model.Library;
import model.Reader;
import service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    public void getReaderMenu() {

    }

    @Override
    public void saveReader(Reader reader,DataBase dataBase) {
        dataBase.getReaders().add(reader);
        System.out.println( "reader Success added");
    }

    @Override
    public List<Reader> getAllReaders(DataBase dataBase) {
        return dataBase.getReaders();
    }

    @Override
    public Reader getReaderById(Long id,DataBase dataBase) {
        for (Reader reader : dataBase.getReaders() ) {
            if (reader.getId().equals(id)) {
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id,DataBase dataBase) {
        for (Reader reader : dataBase.getReaders()) {
            if (id.equals(reader.getId())) {
                System.out.println(" new reader information ");
                reader.setId(id);
                reader.setFullName();
                reader.setEmail();
                reader.setPhoneNumber();
                reader.setGender();
                return  reader;

            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId,DataBase dataBase) {
        for (Reader reader : dataBase.getReaders()) {
            if (reader.getId() == (readerId)) {
                for (Library library : dataBase.getLibraries()) {
                    if (library.getLibraryId().equals(libraryId)) {
                        library.getReaders().add(reader);
                        System.out.println(reader+" successfully added");
                    }else {
                        System.out.println("library not found");
                    }
                }
            }else {
                System.out.println("reader not found ");
            }
        }
    }
}
